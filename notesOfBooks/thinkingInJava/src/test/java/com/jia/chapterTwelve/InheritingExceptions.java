package com.jia.chapterTwelve;

public class InheritingExceptions {
    public void f() throws SimpleException{
        System.out.println("Throw simpleException from f()");
        throw new SimpleException();
    }

    public static void main(String[] args) {
        InheritingExceptions sed = new InheritingExceptions();
        try {
            sed.f();
        } catch (SimpleException e) {
            e.printStackTrace();
        }
    }
}

class SimpleException extends Exception{

}
