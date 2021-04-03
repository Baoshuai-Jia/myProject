package com.jia.observerMode;

import com.jia.observerMode.inte.Observer;
import com.jia.observerMode.inte.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList<Object> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Object o) {
        observers.add(o);
    }

    @Override
    public void removerObserver(Object o) {
        int i = observers.indexOf(o);
        if (i >=0){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidity,pressure);
        }
    }

    public void measurementChanged(){
        notifyObservers();
    }

    public void setMeasurement(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
