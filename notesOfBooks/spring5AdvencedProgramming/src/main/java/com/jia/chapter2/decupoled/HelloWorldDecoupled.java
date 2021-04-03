package com.jia.chapter2.decupoled;

public class HelloWorldDecoupled {
    public static void main(String[] args) {
        MessageRenderer messageRenderer = new HelloWorldMessageRenderer();
        MessageProvider messageProvider = new HelloWorldMessageProvider();
        messageRenderer.setMessageProvider(messageProvider);
        messageRenderer.render();
    }
}
