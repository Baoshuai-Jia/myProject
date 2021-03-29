package com.jia.chapterTen;

public class DoThis {
    void f(){
        System.out.println("DoThis f(): "+this.getClass().hashCode());
    }
    public class Inner{
        public DoThis outer(){
            return DoThis.this;//返回当前对象
        }
    }
    public Inner inner(){
        return new Inner();
    }

    public static void main(String[] args) {
        DoThis dt = new DoThis();
        dt.f();
        Inner dti = dt.inner();
        dti.outer().f();

    }
}
