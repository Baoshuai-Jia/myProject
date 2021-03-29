package com.jia.sevenChapter;

public class Hide {
    public static void main(String[] args) {
        Bart bart = new Bart();
        bart.doH('c');
        bart.doH(1.0f);
        bart.doH(new MilHose());
    }
}

class Home{
    char doH(char c){
        System.out.println("doChar");
        return 'd';
    }
    float doH(float f){
        System.out.println("doFloat");
        return 1.0f;
    }
}

class MilHose{

}

class Bart extends Home{
    void doH(MilHose milHose){
        System.out.println("doh(milHost)");
    }
    char doH(char c){
        System.out.println("doh(milHost+ c)"+c);
        return c;
    }
}