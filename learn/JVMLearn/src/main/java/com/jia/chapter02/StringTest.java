package com.jia.chapter02;

public class StringTest {
    public static void main(String[] args) {
        String s = new String();
        System.out.println("hello");
        StringTest stringTest = new StringTest();
        System.out.println(stringTest.getClass().getClassLoader());
    }
}
