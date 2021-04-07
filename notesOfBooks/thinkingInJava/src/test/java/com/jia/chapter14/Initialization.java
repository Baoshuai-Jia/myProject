package com.jia.chapter14;

import java.util.Random;

class Initable{
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL2 = "123".length();
    static{
        System.out.println("Initializing Initable");
    }
}
class Initable2{
    static  int STATIC_NON_FINAL = 48;
    static{
        System.out.println("Initializing Initable2");
    }
}
class Initable3{
    public static int STATIC_NON_FINAL = 49;
    static{
        System.out.println("Initializing Initable3");
    }
}
public class Initialization{
    public static Random rand = new Random(47);
    public static void main(String[] args) throws ClassNotFoundException {
        Class initable = Initable.class;
        System.out.println("After creating initable ref");
        System.out.println(Initable.STATIC_FINAL);//Does not trigger initialization
        System.out.println(Initable.STATIC_FINAL2);//Does trigger initialization
        System.out.println(Initable2.STATIC_NON_FINAL);//Does trigger initialization
        Class<?> initable3 = Class.forName("com.jia.chapter14.Initable3");

    }
}