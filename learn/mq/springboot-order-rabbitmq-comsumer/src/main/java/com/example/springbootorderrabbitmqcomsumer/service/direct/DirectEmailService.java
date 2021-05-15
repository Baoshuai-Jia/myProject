package com.example.springbootorderrabbitmqcomsumer.service.direct;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"email.direct.queue"})
@Component
public class DirectEmailService {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("email direct 接收到消息： "+ message);
    }
}
