package com.jia.chapterTwelve;

public class ExceptionTest01 {
    public static void main(String[] args) {
        Integer i = null;
        if (i == null) {
            throw new NullPointerException();
        }
        throw new NullPointerException("null");
    }
}
