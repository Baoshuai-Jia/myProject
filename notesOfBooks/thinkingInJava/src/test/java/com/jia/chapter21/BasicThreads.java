package com.jia.chapter21;

public class BasicThreads {
    public static void main(String[] args) {
        Thread thread = new Thread(new LiftOff());
        thread.start();//初始化线程，自动调用liftOff的run方法
        System.out.println("Waiting for LiftOff !");//
    }
}
