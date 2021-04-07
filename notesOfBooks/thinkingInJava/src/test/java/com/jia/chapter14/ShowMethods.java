package com.jia.chapter14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ShowMethods {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> c = Class.forName("com.jia.chapter14.ShowMethods");
        Constructor<?>[] constructors = c.getConstructors();
        Method[] methods = c.getMethods();
        System.out.println("");
    }
    public void test01(){}
    public void test02(String name){}
}
