package com.jia.chapter2.decupoled;

public interface MessageRenderer {
    void render();
    MessageProvider getMessageProvider();
    void setMessageProvider(MessageProvider messageProvider);
}
