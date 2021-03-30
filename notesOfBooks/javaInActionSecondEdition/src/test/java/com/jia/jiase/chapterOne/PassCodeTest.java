package com.jia.jiase.chapterOne;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PassCodeTest {

    //通常写法
    private static final String GREEN = "green";

    public static List<Apple> filterColorApples(List<Apple> apples){
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple: apples){
            if (GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> apples){
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple: apples){
            if (apple.getWeight() > 150){
                result.add(apple);
            }
        }
        return result;
    }

    //新写法 -- 代码作为参数传入
    public static boolean isGreenApple(Apple apple){
        return "green".equalsIgnoreCase(apple.getColor());
    }
    public static boolean isHeavyApple(Apple apple){
        return apple.getWeight() > 150;
    }
    public static List<Apple> filterApples(List<Apple> apples, Predicate<Apple> colorOrWeight){
        ArrayList<Apple> result = new ArrayList<>();
        for (Apple apple : apples){
            if (colorOrWeight.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    @Test
    public void test01(){
        Apple apple = new Apple("green", 100);
        Apple apple1 = new Apple("red", 156);
        ArrayList<Apple> apples = new ArrayList<>();
        apples.add(apple1);
        apples.add(apple);
        System.out.println("方法一颜色"+filterColorApples(apples).get(0));
        System.out.println("方法二颜色"+filterApples(apples,PassCodeTest::isGreenApple).get(0));

        System.out.println("方法一重量"+filterHeavyApples(apples).get(0));
        System.out.println("方法二重量"+filterApples(apples,PassCodeTest::isHeavyApple).get(0));

        System.out.println("lambda ");
        System.out.println("color "+ filterApples(apples,(Apple a)->GREEN.equalsIgnoreCase(a.getColor())).get(0));
        System.out.println("weight "+ filterApples(apples,(Apple a)->a.getWeight() > 150).get(0));
    }
}

