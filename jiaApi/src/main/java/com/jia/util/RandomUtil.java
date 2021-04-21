package com.jia.util;

import java.math.BigDecimal;

public class RandomUtil {


    /**
     *获取 10 位有效数及以上随机数的方法
     * 如： 获取10位有效数字的随机数[1000000000,9999999999]
     * @param digit 获取随机整数的有效位数
     * @return 随机整数的字符串结果
     */
    public static String getBigRandom(int digit){
        while (true){
            BigDecimal bigRandom = getBaseBigRandom(digit);
            if (bigRandom.intValue() >= 0 && bigRandom.intValue() <Math.pow(10,digit)){

            }else {
                String result = bigRandom.toString();
                if (result.length() > digit){
                    result = result.substring(0,digit);
                }
                return result;
            }
        }
    }

    private static BigDecimal getBaseBigRandom(int digit){
        BigDecimal first = new BigDecimal(Math.pow(10,digit));//获取10个0
        BigDecimal bigDecimal = new BigDecimal(1);//在来一个零
        bigDecimal = bigDecimal.multiply(first);//变成11个0
//        System.out.println("长度： "+bigDecimal.toString().length()+"    value: "+bigDecimal);
        BigDecimal scale = new BigDecimal(String.valueOf(Math.random()));//获取随机数[0,1)
        BigDecimal succ = scale.setScale(digit, BigDecimal.ROUND_DOWN);//随机数保留10位有效数字
        bigDecimal = bigDecimal.multiply(succ);//获取到的10位有效的整数；多个区间[0,1000000000)
        return bigDecimal;
    }
}
