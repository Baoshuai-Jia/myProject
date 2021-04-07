package com.jia.decoratorPattern;

public abstract class Beverage {
    protected String description = "Unknown beverage";

    public String getDescription(){
        return description;
    }
    public abstract double cost();
}
