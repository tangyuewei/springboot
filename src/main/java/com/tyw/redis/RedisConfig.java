package com.tyw.redis;

import com.tyw.domian.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisShardInfo;

/**
 * @author : tboss
 * @description : redis启动类
 * @date : 2018/10/18
 */

@Configuration
public class RedisConfig{
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisShardInfo jedisShardInfo = new JedisShardInfo("127.0.0.1");
        jedisShardInfo.setPassword("123");
        return new JedisConnectionFactory(jedisShardInfo);
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, User> template = new RedisTemplate<String, User>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());
        return template;
    }

}