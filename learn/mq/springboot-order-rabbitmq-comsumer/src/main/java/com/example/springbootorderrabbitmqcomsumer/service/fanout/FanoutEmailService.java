package com.example.springbootorderrabbitmqcomsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email.fanout.queue"})
@Component
public class FanoutEmailService {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("email 接收到消息： "+ message);
    }
}
