package com.tyw;

import com.tyw.db.DataSourceEnum;
import com.tyw.db.DynamicDataSource;
import com.tyw.domian.User;
import com.tyw.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static com.tyw.db.DynamicDataSource.getDataSource;

/**
 * Created by tboss on 2017/11/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("slaveJdbcTemplate")
    private JdbcTemplate jdbcTemplate1;
    @Autowired
    @Qualifier(value = "masterJdbcTemplate")
    private JdbcTemplate jdbcTemplate2;

    @Test
    public void findOne(){
        User user = userService.findOne(3);
        System.out.print(user);
        Assert.assertEquals(new String("tyw"),user.getUsername());
    }
    @Test
    public void datasource(){
        System.out.println("!!!!!!"+getDataSource());

        User user1 = userService.findOne(3);
        System.out.println("======user1:"+user1);

        Map jdbc1 = jdbcTemplate2.queryForMap("select * from user  where id = '3'");
        System.out.println("jdbc1======users:"+jdbc1);
        Map jdbc2= jdbcTemplate1.queryForMap("select * from user where id = '3'");
        System.out.println("jdbc2======users:"+jdbc2);
    }
}
