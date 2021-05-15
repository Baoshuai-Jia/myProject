package com.jia.rabbitmq.work.fair;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Work1 {
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
            Channel finalChannel = channel;
            //公平分发一次性从队列中获取多少条数据，考虑cpu和内存使用率
            finalChannel.basicQos(1);
            channel.basicConsume(queueName,false ,new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery message) throws IOException {
                    System.out.println("获取消息成功: "+new String(message.getBody()));
                    //一定要手动应答
                    finalChannel.basicAck(message.getEnvelope().getDeliveryTag(),false);
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
