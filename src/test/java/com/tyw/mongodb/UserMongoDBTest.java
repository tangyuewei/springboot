package com.tyw.mongodb;

import com.tyw.domian.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.*;


/**
 * @author : tboss
 * @description : MongoDB测试
 * @date : 2018/10/22
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserMongoDBTest {

    @Autowired
    private UserMongoDB userRepository;

    @Before
    public void setUp() {
        userRepository.deleteAll();
    }

    @Test
    public void findByUsername() {
        // 创建三个User，并验证User总数
        userRepository.save(new User("didi", "123",new Date(),null,"INIT"));
        userRepository.save(new User("mama", "123",new Date(),null,"INIT"));
        userRepository.save(new User("kaka", "1323",new Date(),null,"INIT"));
        Assert.assertEquals(3, userRepository.findAll().size());
        System.out.println(userRepository.findByUsername("didi"));
    }
}