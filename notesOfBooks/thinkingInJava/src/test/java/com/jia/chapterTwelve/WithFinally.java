package com.jia.chapterTwelve;

public class WithFinally {
    public static void main(String[] args) {
        try {
            throw new Exception("finally");

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}
