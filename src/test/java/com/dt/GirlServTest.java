package com.dt;

import com.dt.domain.Girl;
import com.dt.servive.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by RID on 2017/4/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServTest {

    @Autowired
    private GirlService girlService;


    @Test
    public void testFindOne(){
        Girl girl= girlService.findOneGirl(7);
        Assert.assertEquals(new Integer(19), girl.getAge());

    }
}
