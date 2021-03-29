package com.jia.chapterTwelve;

public class FullConstructions {
    public void f() throws MyException{
        System.out.println("Throwing MyException from f() ");
        throw new MyException();
    }
    public void g(String msg) throws MyException{
        System.out.println("Throwing MyException from g()");
        throw new MyException(msg);
    }

    public static void main(String[] args) {
        FullConstructions full = new FullConstructions();

        try {
            full.f();
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }

        try {
            full.g("params");
        } catch (MyException e) {
            e.printStackTrace(System.out);
        }
    }
}
class MyException extends Exception{
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
