package com.jia.Chapater13.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 1.标准的输入输出流
 * 2。打印流
 * 3。数据流
 */
public class OtherStreamTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input");
        while (scanner.hasNext()){
            System.out.println("input content:"+scanner.next());
        }
        scanner.close();
    }

    /**
     *
     * 1.标准的输入、输出流
     * 1.1
     * System.in:标准的输入流，默认从键盘输入
     * System.out:标准的输出流，默认从控制台输出
     * 1.2
     * System类的setIn(InputStream is)/ setout(PrintStreamps)方式重新指定输入和输出的
     * 1.3练习:
     * 从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续进行输入操作，直至当输入“”或者“exit时，退出程序。
     * 方法一:使用Scanner实现，调用next()返回一个字符串
     * 方法二:使用System.in实现。System.in-->转换流 --> BufferedReader readline
     */
    @Test
    public void test01() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        while (true){
            System.out.println("请输入内容");
            String read = br.readLine();
            if ("e".equalsIgnoreCase(read) || "exit".equalsIgnoreCase(read)){
                break;
            }
            System.out.println(read);
        }
        br.close();
    }
}
