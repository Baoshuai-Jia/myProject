package com.jia.decoratorPattern;

public class StarbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage = new HouseBlend();
        beverage = new Mocha(beverage);//2倍的摩卡
        beverage = new Mocha(beverage);

    }
}
