package com.jia.chapter21;

public class SimplePriorities implements Runnable{
    private int countDown = 5;
    private volatile double d;
    private int priority;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return Thread.currentThread()+" : "+countDown;
    }

    @Override
    public void run() {
        while (true){
            for (int i = 0; i < 100000; i++) {
                d+= (Math.PI + Math.E)/(double)i;
                if (i /1000 ==0) Thread.yield();
            }

        }
    }
}
