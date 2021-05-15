package com.example.springbootorderrabbitmqcomsumer.service.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@RabbitListener(queues = {"duanxin.fanout.queue"})
@Component
public class FanoutDuanxinService {
    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("duanxin  接收到消息： "+ message);
    }
}
