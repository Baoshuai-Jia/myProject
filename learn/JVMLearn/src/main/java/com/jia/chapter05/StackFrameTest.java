package com.jia.chapter05;

public class StackFrameTest {
    public static void main(String[] args) {
        System.out.println("开始执行main方法");
        method1();
        System.out.println("main方法执行结束");
    }

    private static void method1() {
        System.out.println("开始执行method1方法");
        method2();
        System.out.println("method1方法执行结束");
    }

    private static int method2() {
        System.out.println("开始执行method2方法");
        int i = 10;
        int m = (int) method3();
        System.out.println("method2方法执行即将结束");
        return i+m;
    }

    private static double method3() {
        System.out.println("开始执行method3方法");
        double m = 20.0;
        System.out.println("main方法之心结束");
        return m;
    }
}
