package com.jia.chapter14;

import java.util.Arrays;
import java.util.List;

public abstract class Shape {
    public void draw() {
        System.out.println(this + ".drow()");// 字符串运算符,参数 this 间接的调用了 toString() 方法
    }

    abstract public String toString();// abstract 表示强制子类覆盖此方法
}

class Circle extends Shape {
    public String toString() {
        return "Circle";
    }
}

class Square extends Shape {
    public String toString() {
        return "Square";
    }
}

class Shapes {
    public static void main(String[] args) {
        List<Shape> shapeList = Arrays.asList(new Circle(), new Square());

        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        // boolean.class
        // 当从数组中取出元素时,这种容器——实际上它将所有的事物都当作Object持有——会自动将结果转型回Shape,这是RTTI最基本的使用形式,
        for (Shape shape : shapeList) {
            shape.draw();
            System.out.println(shape.getClass().getCanonicalName());
        }
    }
}