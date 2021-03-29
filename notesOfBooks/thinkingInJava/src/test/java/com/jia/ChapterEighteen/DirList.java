package com.jia.ChapterEighteen;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
    public static void main(String[] args) {
        File path = new File("/Users/jia/IdeaProjects/github/myProject/notesOfBooks/thinkingInJava/src/test/java/com/jia/ChapterEighteen");
        String[] fileList;
        fileList = path.list(new DirListFilter(".*\\.java"));//获取文件列表
        Arrays.sort(fileList,String.CASE_INSENSITIVE_ORDER);//排序 case_insensitive_order
        for (String filePath: fileList){
            System.out.println(filePath);
        }
    }
}

class DirListFilter implements FilenameFilter{//使用filter过滤java文件
    private Pattern pattern;

    public DirListFilter(String regex) {
        pattern = Pattern.compile(regex);
    }
    @Override
    public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
    }
}
