package com.example.springbootorderrabbitmqcomsumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class TTLRabbitMQConfiguration {

    //1。声明交换机
    public DirectExchange directExchangeTTL(){
        return new DirectExchange("ttl-direct-exchange",true,false);
    }


    //2。 声明队列
    @Bean
    public Queue directTTLQueue(){
        HashMap<String, Object> args = new HashMap<>();
        args.put("x-message-ttl", 60000);
        return new Queue("ttl.direct.queue",true,false,false,args);
    }



    //3。 队列绑定交换机
    @Bean
    public Binding directTTLBinding(){
        return BindingBuilder.bind(directTTLQueue()).to(directExchangeTTL()).with("ttl");
    }
}
