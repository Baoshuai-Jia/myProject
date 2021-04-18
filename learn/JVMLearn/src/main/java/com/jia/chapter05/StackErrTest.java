package com.jia.chapter05;
/**
 * 演示栈异常：StackOverFlow
 */
public class StackErrTest {
    private static int count = 1;
    public static void main(String[] args) {
        System.out.println(count);
        count++;
        main(args);
    }
}
