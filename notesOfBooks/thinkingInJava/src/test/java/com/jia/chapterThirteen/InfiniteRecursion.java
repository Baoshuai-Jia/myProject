package com.jia.chapterThirteen;

public class InfiniteRecursion {
    @Override
    public String toString() {
        return ""+System.identityHashCode(this);// 等于 字符串+this.toString 这样就陷入了无限循环中  StackOverflowError
    }

    public static void main(String[] args) {
        InfiniteRecursion recursion = new InfiniteRecursion();
        System.out.println(recursion);
        System.out.printf("ROW 1 : %d %f",1,1.01f);
        System.out.println();
        System.out.printf(String.format("ROW 1 : %d %f",1,1.01f));

    }


}
