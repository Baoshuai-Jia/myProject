package com.jia.chapterTen;

public class DotNow {
    public class Inner{

    }

    public static void main(String[] args) {
        DotNow dn = new DotNow();
        Inner inner = dn.new Inner();//创建内部类对象
    }
}
