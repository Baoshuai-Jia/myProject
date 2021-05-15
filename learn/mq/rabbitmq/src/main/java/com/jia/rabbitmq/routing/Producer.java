package com.jia.rabbitmq.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.33.11");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");//类似磁盘分区（c盘、d盘）;或者类似db的数据库
        Connection connection =null;
        Channel channel = null;
        try {
            connection = connectionFactory.newConnection("生产者2");
            channel = connection.createChannel();

            String exchangeName = "fanout-exchange";
            String routingKey = "";
            String type = "fanout";
            String message = "hello fanout! ";
            channel.exchangeDeclare(exchangeName,type);
            channel.basicPublish(exchangeName,routingKey,null,message.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null && channel.isOpen()){
                    channel.close();
                }
                if (connection != null && connection.isOpen()){
                    connection.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }

    }
}
