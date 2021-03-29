package com.jia.javaApi.regex;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class TestPattern {
    @Test
    public void test(){
        List<String> strings = Arrays.asList("test.java", "test1.java", "test3.md", "test.txt");
        String regex = ".*\\.java";
        Pattern pattern = Pattern.compile(regex);
        for (String string : strings){
            boolean matches = string.matches(regex);
            System.out.println(matches);
        }

    }
}
