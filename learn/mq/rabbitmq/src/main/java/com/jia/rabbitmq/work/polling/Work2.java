package com.jia.rabbitmq.work.polling;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Work2 {
    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.33.11");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = null;
        Channel channel = null;

        try {
            connection = connectionFactory.newConnection("生产者1");
            channel = connection.createChannel();
            String queueName = "queue1";

            channel.basicConsume(queueName,true, new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery message) throws IOException {
                    System.out.println("获取消息成功: "+new String(message.getBody()));
                }
            }, new CancelCallback() {
                @Override
                public void handle(String consumerTag) throws IOException {
                    System.out.println("获取消息失败");
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
//            if (channel != null && channel.isOpen()){
//                channel.close();
//            }
//            if (connection != null && connection.isOpen()){
//                connection.close();
//            }
        }
    }
}
