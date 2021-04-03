package com.jia;

public interface MethodOfInterface {

    void test02();

    default void test01(){
        System.out.println("接口中默认的方法体！");
    };

}
