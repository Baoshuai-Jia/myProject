package com.jia.chapter05;

import java.util.Date;

public class LocalVariableTest {
    private int count =0;

    public static void main(String[] args) {
        LocalVariableTest test = new LocalVariableTest();
        int num = 10;
        test.test01();
    }

    private void test01() {
        Date date = new Date();
        String name = "wendy";
        String info = test02(date,name);
        System.out.println(date+name);
    }

    private String test02(Date date, String name) {
        date = null;
        name = "jiabaoshuai";
        double weight = 130.5;

        return "";
    }
}
