package com.jia.chapterEleven;

import java.util.Iterator;
import java.util.PriorityQueue;

public class IterableClass implements Iterable<String>{
    String[] words = "Now my english is pool".split(" ");
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        IterableClass iterableClass = new IterableClass();
        for (String str :iterableClass){
            System.out.println(str);
        }
        PriorityQueue<Integer> integers = new PriorityQueue<>();
        integers.comparator();
    }
}
