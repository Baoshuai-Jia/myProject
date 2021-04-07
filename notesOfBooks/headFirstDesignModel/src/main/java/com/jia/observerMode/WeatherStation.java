package com.jia.observerMode;

import java.util.Observable;
import java.util.Observer;

public class WeatherStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay conditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurement(1.0F,2.0F,3.0F);
    }
}
