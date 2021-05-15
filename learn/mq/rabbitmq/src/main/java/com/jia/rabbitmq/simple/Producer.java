package com.jia.rabbitmq.simple;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Producer {
    public static void main(String[] args) throws IOException, TimeoutException {

        //所有的中间件技术都是基于tcp/ip协议基础之上构建新型的协议规范，只不过rabbitmq遵循的是amgp// ip port
        //1:创建连接工程
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.33.11");
        connectionFactory.setPort(5672);
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");//类似磁盘分区（c盘、d盘）;或者类似db的数据库
        Connection connection = null;
        Channel channel = null;
        try {
            //2:创建连接Connection
            connection = connectionFactory.newConnection("生产者1");
            //3:通过连接获取通道 Channel
            channel = connection.createChannel();
            //4:通过通创建交换机,声明队列,绑定关系,路由key,发送消息,和接收消息
            String queueName = "queue1";
            /**
             * @param1 队列的名称
             * @param2 是否要持久化 durable= false所谓持久化消息是否存盘,如果 false非持久化true是持久化?非持久化会存盘吗?
             * @param3 排他性,是否是独占独立
             * @param4 是否自动删除,随着最后一个消费者消息完毕消息以后是否把队列自动删除
             * @param5 携带附属参数
             */
            channel.queueDeclare(queueName,true,false,false,null);
            //5:准备消息内容
            String message = "hello queue one";
            //6:发送消息给队列 Iqueue
            channel.basicPublish("",queueName,null,message.getBytes());
            //7:关闭连接
            //8:关闭通道
            System.out.println("success ");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        } finally {
            if (channel != null && channel.isOpen()){
                channel.close();
            }
            if (connection != null && connection.isOpen()){
                connection.close();
            }
        }
    }
}
