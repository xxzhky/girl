package com.dt.mapper;

import com.dt.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by RID on 2017/4/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper mapper;

    @Test
    @Rollback
    public void findByName() throws Exception {
        mapper.insert("AAA", 20);
        User u = mapper.findByName("AAA");
        Assert.assertEquals(20, u.getAge().intValue());

    }

    @Test
    @Rollback
    public void testUserMapper() throws Exception {
        List<User> userList = mapper.findAll();
        for(User user : userList) {
            Assert.assertEquals(null, user.getId());
            Assert.assertNotEquals(null, user.getAge());
        }
    }

}