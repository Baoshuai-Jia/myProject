package com.jia.spring5;

/**
 * 使用setter方式注入
 */
public class Book {
    private String bname;
    private String bauthor;

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    //setter 方法注入
    public void setBname(String bname) {
        this.bname = bname;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                '}';
    }

    //有参构造器注入
//    public Book(String bname) {
//        this.bname = bname;
//    }
}
