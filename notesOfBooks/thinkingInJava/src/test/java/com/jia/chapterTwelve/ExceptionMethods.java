package com.jia.chapterTwelve;

public class ExceptionMethods {
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("caught Exception");
            System.out.println("getMessage(): "+e.getMessage());
            System.out.println("getLocalizedMessage(): "+e.getLocalizedMessage());
            System.out.println("toString(): "+e.toString());
            System.out.println("printStackTrace");
            e.printStackTrace(System.out);
            trace(e);
            throw new RuntimeException("test");
        }
    }

    private static void trace(Exception e) {
        for (StackTraceElement element: e.getStackTrace()){
            System.out.println(element.getMethodName());
        }
    }
}
