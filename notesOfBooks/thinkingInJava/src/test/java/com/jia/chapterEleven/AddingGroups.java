package com.jia.chapterEleven;

import java.util.*;

public class AddingGroups {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<>(Arrays.asList(1,2,3));
        Collection<Integer> i = Arrays.asList(1, 2, 3);
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
//        Integer[] morInt = {1,2,3,4,5,6};
        Collections.addAll(a,1,2);
//        Collections.addAll(i,1,2);//错误
        for (Integer x : i){
            System.out.print(x+" ,");
        }
        System.out.println(a.indexOf(3));
        List<Integer> subList = a.subList(0, 2);
        System.out.println(a.containsAll(subList));
        a.set(1,2);
        a.addAll(i);
        a.clear();
        System.out.println(a.isEmpty());
    }
}
