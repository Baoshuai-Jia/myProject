package com.jia.sevenChapter;

import org.junit.Test;

public class TransformationTest {
    @Test
    public void test(){
        Animal animal = new Person();
        animal.eat();
        Person animal1 = (Person) animal;
        animal1.intelligence();
    }
}
class Animal{
    public void eat(){
        System.out.println("eat");
    }

    public void play(){
        System.out.println("play");
    }
}

class Person extends Animal{

    public void intelligence(){
        System.out.println("intelligence");
    }
}
