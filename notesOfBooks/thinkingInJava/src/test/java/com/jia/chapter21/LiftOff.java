package com.jia.chapter21;

public class LiftOff implements Runnable{

    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    public LiftOff() {
    }

    public void status(){
        System.out.print("# "+id+"("+(countDown > 0 ? countDown : " LiftOff ! ")+"),");

    }

    @Override
    public void run() {
        System.out.println("thread name :"+Thread.currentThread().getName());
        while (countDown-->0){
            status();
            Thread.yield();
        }
    }
}
