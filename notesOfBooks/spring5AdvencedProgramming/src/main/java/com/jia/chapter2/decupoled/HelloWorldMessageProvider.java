package com.jia.chapter2.decupoled;

public class HelloWorldMessageProvider implements MessageProvider{
    @Override
    public String getMessage() {
        return " MessageProvider: Hello World";
    }
}
