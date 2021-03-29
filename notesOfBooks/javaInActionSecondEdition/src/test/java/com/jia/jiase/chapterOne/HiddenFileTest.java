package com.jia.jiase.chapterOne;


import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class HiddenFileTest {
    //方法引用
    @Test
    public void test(){
        File[] files = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        assert files != null;
        System.out.println(" 当前隐藏的文件的list size "+ files.length);
    }
    @Test
    public void test2(){
        File[] files = new File(".").listFiles(File::isHidden);//
        assert files != null;
        System.out.println(" 当前隐藏的文件的list size "+ files.length);
    }

    //lambda
    @Test
    public void test03(){
    }
}
