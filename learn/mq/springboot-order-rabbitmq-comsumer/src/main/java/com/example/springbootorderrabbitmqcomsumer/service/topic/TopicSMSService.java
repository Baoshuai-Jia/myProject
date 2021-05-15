package com.example.springbootorderrabbitmqcomsumer.service.topic;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@RabbitListener(bindings = @QueueBinding(
        value = @Queue(value = "sms.topic.queue",durable = "true",autoDelete = "false"),
        exchange = @Exchange(value = "topic_order_exchange",type = ExchangeTypes.TOPIC,durable = "true"),
        key = "#.sms.#"
))
@Component
public class TopicSMSService {

    @RabbitHandler
    public void receiveMessage(String message){
        System.out.println("sms topic 接收到消息： "+ message);
    }
}
