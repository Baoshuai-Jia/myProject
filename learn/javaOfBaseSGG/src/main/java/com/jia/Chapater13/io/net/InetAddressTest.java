package com.jia.Chapater13.io.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 三、通信要素一:IP和端口号
 * 1.ip:唯一的标识 Internet上的计算机(通信实体)
 * 2.在ava中使用 InetAddress类代表P
 * 3.IP分类:IP4和IPv6;万维网和局域网
 *  4. 8:  www. baidu. com ww. mi.com www. sina. com www.id. com
 *  www. Vip. com
 * 5.本地回路地址:127..日.1对应着: Localhost
 * 6.如何实例化 InetAddress:两个方法: getByName string host、 getLocaLHos
 * 两个常用方法: getHos tName()/ getHostAddress()
 * 7.端口号:正在计算机上运行的进程。
 * 要求:不同的进程有不同的端口号
 * 范围:被规定为一个16位的整数~65535。
 * 8.端口号与IP地址的组合得出一个网络套接字:Socket
 */
public class InetAddressTest {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress);
        InetAddress baidu = InetAddress.getByName("www.baidu.com");
        System.out.println(baidu);
        //获取域名
        String hostName = baidu.getHostName();
        //获取ip地址
        String hostAddress = baidu.getHostAddress();
        System.out.println(hostName);
        System.out.println(hostAddress);
        //获取本机的IP
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost.getHostAddress());
        //
    }
}
