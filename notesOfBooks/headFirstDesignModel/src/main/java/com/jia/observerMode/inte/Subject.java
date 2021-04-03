package com.jia.observerMode.inte;

public interface Subject {
    public void registerObserver(Object o);

    public void removerObserver(Object o);

    public void notifyObservers();
}
