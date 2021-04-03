package com.jia.observerMode;

import com.jia.observerMode.inte.DisplayElement;
import com.jia.observerMode.inte.Observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    private float pressure;
    private WeatherData weatherData;

    public CurrentConditionDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                ", weatherData=" + weatherData +
                '}');
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        temperature =temp;
        this.humidity = humidity;
        display();
    }
}
