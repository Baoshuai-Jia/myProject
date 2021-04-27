package com.jia;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class TestTX {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.33.10", 6379);
        jedis.auth("123456");

        jedis.set("money","100");
        jedis.watch("money");
        Transaction multi = jedis.multi();
        multi.incr("money");
        multi.exec();
//        multi.discard();//放弃事务
        System.out.println(jedis.get("money"));
    }
}
