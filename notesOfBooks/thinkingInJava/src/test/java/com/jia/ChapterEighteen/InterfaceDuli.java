package com.jia.ChapterEighteen;

public class InterfaceDuli {
}

interface I1{
    void f();
}
interface I2{
    void f(int i);
}
interface I3{
    int f();
}
class C1{
    public int  f(){ return 1;};
}
class C2 implements I1,I2{

    @Override
    public void f() {

    }

    @Override
    public void f(int i) {

    }
}

class C3 extends C2 implements I1{
    @Override
    public void f(int i) {
        super.f(i);
    }
}
class C4 extends C1 implements I3{
    public int f(){
        return 0;
    };
}
