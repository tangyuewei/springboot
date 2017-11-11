package com.tyw;

import com.tyw.domian.User;
import com.tyw.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by tboss on 2017/11/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void findOne(){
        User user = userService.findOne(1001);
        System.out.print(user);
        Assert.assertEquals(new String("tyw"),user.getUsername());
    }
}
