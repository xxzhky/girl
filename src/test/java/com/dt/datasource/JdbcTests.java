package com.dt.datasource;

import com.dt.domain.User;
import com.dt.domain.p.Student;
import com.dt.domain.s.Message;
import com.dt.repository.p.StudentRepository;
import com.dt.repository.s.MessageRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by RID on 2017/4/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcTests {

    @Autowired
    @Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate1;

    @Autowired
    @Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate jdbcTemplate2;

    @Before
    public void setUp() {
        jdbcTemplate1.update("DELETE  FROM  user ");
        jdbcTemplate2.update("DELETE  FROM  user ");
    }

    @Test
    public void testJdbc() throws Exception {

        // 往第一个数据源中插入两条数据
        jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);
        jdbcTemplate1.update("insert into user(id,name,age) values(?, ?, ?)", 2, "bbb", 30);

        // 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
        jdbcTemplate2.update("insert into user(id,name,age) values(?, ?, ?)", 1, "aaa", 20);

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
        Assert.assertEquals("2", jdbcTemplate1.queryForObject("select count(1) from user", String.class));

        // 查一下第一个数据源中是否有两条数据，验证插入是否成功
        Assert.assertEquals("1", jdbcTemplate2.queryForObject("select count(1) from user", String.class));

    }

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testJpaRepo() throws Exception {

        studentRepository.deleteAll();
        studentRepository.save(new Student("aaa", 10));
        studentRepository.save(new Student("bbb", 20));
        studentRepository.save(new Student("ccc", 30));
        studentRepository.save(new Student("ddd", 40));
        studentRepository.save(new Student("eee", 50));

        Assert.assertEquals(5, studentRepository.findAll().size());

        messageRepository.deleteAllInBatch();
        messageRepository.save(new Message("o1", "aaaaaaaaaa"));
        messageRepository.save(new Message("o2", "bbbbbbbbbb"));
        messageRepository.save(new Message("o3", "cccccccccc"));

        Assert.assertEquals(3, messageRepository.findAll().size());

    }

}
