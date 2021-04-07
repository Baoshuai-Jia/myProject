package com.jia.jes;

import com.jia.MethodOfInterface;
import com.jia.MethodOfInterfaceImple;
import com.test.MethodOfInterfaceTest02;
import com.test.MethodOfInterfaceTest03;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test01 implements Cloneable{

    //vscode
    @Test
    public void test(){
        System.out.println("Test 01  ");
    }

    @Test
    public void test02(){
        MethodOfInterface methodOfInterface = new MethodOfInterfaceImple();
        methodOfInterface.test01();
        MethodOfInterfaceTest02 test02 = new MethodOfInterfaceTest02();
        test02.test01();
        test02.test02();
        MethodOfInterfaceTest03 test03 = new MethodOfInterfaceTest03();
    }
}
