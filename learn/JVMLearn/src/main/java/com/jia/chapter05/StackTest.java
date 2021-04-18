package com.jia.chapter05;

public class StackTest {
    public static void main(String[] args) {
        StackTest test = new StackTest();
        test.testA();
    }

    public void testA(){
        int i = 10;
        int j = 20;
        testB();
    }
    public void testB(){
        int m = 30;
        int n = 40;
    }
}
