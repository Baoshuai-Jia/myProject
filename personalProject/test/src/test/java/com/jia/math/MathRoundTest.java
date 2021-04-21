package com.jia.math;

import org.junit.Test;

import java.math.BigDecimal;

public class MathRoundTest {
    @Test
    public void test01(){
        BigDecimal first = new BigDecimal(1000000000);//获取10个0
        BigDecimal bigDecimal = new BigDecimal(10);//在来一个零
        bigDecimal = bigDecimal.multiply(first);//变成11个0
//        System.out.println("长度： "+bigDecimal.toString().length()+"    value: "+bigDecimal);
        BigDecimal scale = new BigDecimal(String.valueOf(Math.random()));//获取随机数[0,1)
        BigDecimal succ = scale.setScale(10, BigDecimal.ROUND_DOWN);//随机数保留10位有效数字
        bigDecimal = bigDecimal.multiply(succ);//获取到的10位有效的整数；多个区间[0,1000000000)
        if (bigDecimal.intValue() >= 0 && bigDecimal.intValue() <1000000000){
            test01();
        }else {
            System.out.println(bigDecimal);
        }

//        System.out.println("长度： "+bigDecimal.toString().length()+"    value: "+bigDecimal);
    }
}
