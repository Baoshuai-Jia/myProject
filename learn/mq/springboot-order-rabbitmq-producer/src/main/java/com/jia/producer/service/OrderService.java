package com.jia.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void makeOrder(){
        String orderid = UUID.randomUUID().toString();

        System.out.println("下单成功");
        String exchangeName = "fanout_order_exchange";
        String routingKey = "";

        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderid);

    }
    public void makeDirectOrder(){
        String orderid = UUID.randomUUID().toString();

        System.out.println("下单成功");
        String exchangeName = "direct_order_exchange";
        String routingKey = "";

        rabbitTemplate.convertAndSend(exchangeName,"duanxin",orderid);
        rabbitTemplate.convertAndSend(exchangeName,"email",orderid);

    }
    public void makeTopicOrder(){
        String orderid = UUID.randomUUID().toString();

        System.out.println("下单成功");
        String exchangeName = "topic_order_exchange";
        String routingKey = "com.sms.duanxin.sms.test";

        rabbitTemplate.convertAndSend(exchangeName,routingKey,orderid);

    }
}
