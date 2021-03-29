package com.jia.chpater21;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable{
    private int priority ;
    private static int count = 10000;

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        count();
    }
    private ArrayList<String> minList = new ArrayList<String>();
    private ArrayList<String> maxList = new ArrayList<String>();
    private ArrayList<String> normList = new ArrayList<String>();
    private synchronized void  count(){
        for (int i = 0; i <= count; count--) {
            if (Thread.currentThread().getPriority() == Thread.MAX_PRIORITY){
                maxList.add(Thread.currentThread().getName()+":  "+priority+" "+i);
            }

            if (Thread.currentThread().getPriority() == Thread.MIN_PRIORITY){
                maxList.add(Thread.currentThread().getName()+":  "+priority+" "+i);
            }

            if (Thread.currentThread().getPriority() == Thread.NORM_PRIORITY){
                maxList.add(Thread.currentThread().getName()+":  "+priority+" "+i);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (count/10==0){
                Thread.yield();
            }
            if (count == 0){
                System.out.println("max thread :"+maxList.size());
                System.out.println("norm thread :"+normList.size());
                System.out.println("min thread :"+minList.size());
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.execute(new SimplePriorities(Thread.NORM_PRIORITY));
        exec.shutdown();
    }
}
