package com.jia.chapterEleven;

import java.util.*;

public class LinkedListFeature {
    public static void main(String[] args) {
        LinkedList<String> pets = new LinkedList<>(Arrays.asList("jia","wendy","lucy"));

        System.out.println("pets.getFirst(): "+pets.getFirst());//返回第一个元素
        System.out.println("pets.element : "+pets.element());//返回第一个元素

        System.out.println("pets.peek() :"+ pets.peek());//检索，但是不删除第一个元素

        System.out.println(pets.poll());//检索并删除第一个元素
        System.out.println("pets.remove() : "+ pets.remove());//检索删除并返回头元素
        System.out.println("pets.removeFirst(): "+pets.removeFirst());//删除并返回第一个元素
        pets.addFirst("tom");//添加元素在头部
        System.out.println(pets);
        pets.offer("lily");//添加元素在尾部
        System.out.println(pets);
        System.out.println(pets.removeLast());//删除尾部元素
        System.out.println(pets);//

        HashSet<String> strings = new HashSet<>();
        strings.add("jia");
        strings.add("wendy");
        strings.add("wendy");
        HashMap<String, String> people = new HashMap<>();
        people.keySet();
        people.containsKey("");

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(1);//添加元素
        queue.offer(2);//添加元素
        queue.add(6);
        System.out.println(queue.peek());//检索并返回
        System.out.println(queue.poll());//删除并返回
        System.out.println(queue.remove());//删除第一个元素
        System.out.println(queue.remove(6));//删除指定元素
        System.out.println(queue);
    }
}
