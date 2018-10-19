package com.tyw.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author : tboss
 * @description : 测试redis
 * @date : 2018/10/19
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisConfigTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws Exception {

        // 保存字符串
        redisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));

    }
}