package com.jia.Chapater13.io;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用：
 * ObjectInputStream ObjectOutputStream
 * 作用：用于存储和读取基本数据类型数据或对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 */
public class ObjectInputOutputStreamTest {

    /*
     序列化：把内存中的对象保存到磁盘或者通过网络传输到其他服务器
     使用ObjectInputStream实现
     */
    @Test
    public void objectOutputStreamTest(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("object.dat")));
            oos.writeObject(new String("wendy 贾"));
            oos.flush();
            //要想一个对象可以序列化： 该对象必须实现 Serializable接口或者 Externalizable
            oos.writeObject(new Person("wendy",18));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /*
        反序列化:将磁盘中的序列化的对象还原成内存中的对象
        使用 ObjectInputStream实现
     */
    @Test
    public void objectInputStreamTest(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("object.dat")));
            String result = (String) ois.readObject();
            System.out.println(result);
            Person p = (Person)ois.readObject();
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

/**
 * Person可以被序列化要求；
 * 1。  该对象必须实现 Serializable接口或者 Externalizable
 * 2。需要当前类提供一个全局变量： serialVersionUID, 序列化的时候java会自动生成一个uID， 但是当person类修改后，UID会发生变化，反序列化的时候有异常java.io.InvalidClassException
 *  还必须保证其内部的属性都可以序列还（基本数据类型都可以序列化--其包装类有实现Serializable接口） knowledge
 *  3。 ObjectOutputStream和 ObjectInputStream不能序列化 static和 TRansient修饰的成员变量；那么该变量的值为默认值
 */
class Person implements Serializable{
    private static final long serialVersionUID = 421234134134L;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
