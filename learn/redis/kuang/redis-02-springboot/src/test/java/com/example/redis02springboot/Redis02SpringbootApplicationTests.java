package com.example.redis02springboot;

import com.example.redis02springboot.pojo.User;
import com.example.redis02springboot.util.RedisUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class Redis02SpringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;
    @Test
    void contextLoads() {

        //opsForValue 操作字符串
        //opsForList 操作list
        //opsForSet
        //opsForZSet
        //opsForHash
        //opsForGeo
        //opsForHyperLogLog
//        redisTemplate.opsForHyperLogLog();
//
//        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
//        connection.flushAll();;
//        connection.flushDb();

        redisTemplate.opsForValue().set("name","wendy");
        System.out.println(redisTemplate.opsForValue().get("name"));
    }

    @Test
    public void test() throws JsonProcessingException {
        //真实开发都是用json
        User user = new User();
        user.setAge(19);
        user.setName("wendy贾");
        String s = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",s);
        redisTemplate.opsForValue().set("user1",user);// 没有序列化，不可以直接写pojo对象，String可以
        System.out.println(redisTemplate.opsForValue().get("user"));
        System.out.println(redisTemplate.opsForValue().get("user1"));
    }

    @Test
    public void test02(){
        RedisUtil redisUtil = new RedisUtil();
//        redisUtil.lRemove()
    }

}
