package com.jia.chapter02;

public class ClInitTest {
    //任何一个类都至少有一个构造器

    private int a = 1;

    private static int c = 3;//没有这一行就没有clinit
    public static void main(String[] args) {
        int b =2;
    }

    public ClInitTest() {
        a =10;
        int d =20;
    }
}
