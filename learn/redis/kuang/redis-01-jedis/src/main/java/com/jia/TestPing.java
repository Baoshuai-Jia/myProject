package com.jia;

import redis.clients.jedis.Jedis;

public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.33.10", 6379);
        jedis.auth("123456");
        System.out.println(jedis.ping());

    }
}
