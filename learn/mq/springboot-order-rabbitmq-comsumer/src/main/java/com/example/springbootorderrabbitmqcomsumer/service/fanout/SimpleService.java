package com.example.springbootorderrabbitmqcomsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queuesToDeclare = @Queue (value = "hello"))
@Component
public class SimpleService {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("Hello  接收到消息： "+ message);
    }
}
