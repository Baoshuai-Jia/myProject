package com.jia.decoratorPattern;

public abstract class CondimentDecorator extends Beverage{
    public abstract String getDescription();//所有的装饰者必须实现
}
