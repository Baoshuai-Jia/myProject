package com.jia.chapterThirteen;

import org.junit.Test;

public class RegexTest {
    @Test
    public void test(){
        System.out.println("-123?1".matches("-?\\d+\\??"));
        System.out.println("?123".matches("([-+j?])?\\d+"));//([-+j])? 表示[]里的元素出现 0 次或 1 次;[]里面的都是普通字符
    }
}
