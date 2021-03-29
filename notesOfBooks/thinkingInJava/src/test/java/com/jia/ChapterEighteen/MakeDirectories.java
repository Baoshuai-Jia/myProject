package com.jia.ChapterEighteen;

import com.jia.util.DateConstant;
import com.jia.util.DateUtils;
import org.junit.Test;

import java.io.File;

public class MakeDirectories {
    public static void usage(){

    }
    public static void fileData(File file){
        System.out.println(
                "Absolute path : " + file.getAbsolutePath()+
                        "\n can read :"+ file.canRead()+
                        "\n can write : "+file.canWrite()+
                        "\n getName :"+ file.getName()+
                        "\n getParent : "+ file.getParent() +
                        "\n getPath :" + file.getPath() +
                        "\n length : "+ file.length()+
                        "\n lastModified: "+ DateUtils.toTodayFrom1970(file.lastModified(), DateConstant.YEAR_TO_SECOND01)
        );
        if (file.isFile()){
            System.out.println(" It is a file");
        }
        if (file.isDirectory()){
            System.out.println(" IT is a direction");
        }
    }

    @Test
    public void test(){
        fileData(new File("/Users/jia/IdeaProjects/github/myProject/notesOfBooks/thinkingInJava/src/test/java/com/jia/ChapterEighteen/MakeDirectories.java"));
    }
}
