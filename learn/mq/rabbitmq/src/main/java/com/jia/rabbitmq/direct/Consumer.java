package com.jia.rabbitmq.direct;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    private static Runnable run = new Runnable() {
        @Override
        public void run() {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("192.168.33.11");
            connectionFactory.setPort(5672);
            connectionFactory.setUsername("guest");
            connectionFactory.setPassword("guest");
            connectionFactory.setVirtualHost("/");
            Connection connection = null;
            Channel channel = null;

            try {
                String exchangeName = "direct-exchange";

                final String queueName = Thread.currentThread().getName();
                connection = connectionFactory.newConnection("消费者2");
                channel = connection.createChannel();
                channel.queueDeclare(queueName,false,false,false,null);
                channel.queueBind(queueName,exchangeName,"email");
                channel.basicConsume(queueName, new DeliverCallback() {
                    @Override
                    public void handle(String consumerTag, Delivery message) throws IOException {
                        System.out.println(queueName+" 接收消息成功： " + new String(message.getBody()));
                    }
                }, new CancelCallback() {
                    @Override
                    public void handle(String consumerTag) throws IOException {
                        System.out.println(" 接收消息 异常");
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
//                try {
//                    if (channel != null && channel.isOpen()){
//                        channel.close();
//                    }
//                    if (connection != null && connection.isOpen()){
//                        connection.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } catch (TimeoutException e) {
//                    e.printStackTrace();
//                }
            }
        }
    };

    public static void main(String[] args) {
        new Thread(run, "queue1").start();
        new Thread(run, "queue2").start();
        new Thread(run, "queue3").start();
    }
}
