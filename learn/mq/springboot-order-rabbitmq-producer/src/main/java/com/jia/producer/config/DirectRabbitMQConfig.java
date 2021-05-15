package com.jia.producer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectRabbitMQConfig {

    //1.声明exchange交换机
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct_order_exchange",true,false);
    }
    //2.声明队列sms.fanout.queue   duanxin.fanout.queue   email.fanout.queue
    @Bean
    public Queue smsDirectQueue(){
        return new Queue("sms.direct.queue",true);
    }
    @Bean
    public Queue duanxinDirectQueue(){
        return new Queue("duanxin.direct.queue",true);
    }
    @Bean
    public Queue emailDirectQueue(){
        return new Queue("email.direct.queue",true);
    }
    //1.交换机和队列绑定
    @Bean
    public Binding ssmDirectBinding(){
        return BindingBuilder.bind(smsDirectQueue()).to(directExchange()).with("email");
    }
    @Bean
    public Binding duanxinDrectBinding(){
        return BindingBuilder.bind(duanxinDirectQueue()).to(directExchange()).with("sms");
    }
    @Bean
    public Binding emailDirectBinding(){
        return BindingBuilder.bind(emailDirectQueue()).to(directExchange()).with("duanxin");
    }
}
