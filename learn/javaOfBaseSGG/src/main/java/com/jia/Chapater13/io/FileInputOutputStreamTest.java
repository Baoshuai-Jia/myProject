package com.jia.Chapater13.io;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;

public class FileInputOutputStreamTest {

    /**
     * 总结：
     * 1.对于文本文件(.txt,java,.c,cpp),使用字符流处理
     * 2.对于非文本文件(jpg,mp3,mp4,ai,.doc,.ppt,),使用字节流处理
     */
    @Test
    public void testFileInputStream()  {
        FileInputStream fileInputStream = null;
        try {
            File file = new File("hello.txt");
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[5];
            int len;//记录每次读取的字节的个数
            while ((len = fileInputStream.read(bytes)) != -1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 实现对图片的一个复制操作
     */
    @Test
    public void fileInputOutputStreamTest(){
        File srcFile = new File("xiaowu.png");
        File descFile = new File("xiaowu2.png");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            byte[] buffer = new byte[5];
            int len;
            while (( len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if ( fis != null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    //复制文件
    //@Test
    public long copyWithInputOutputStreamTest(String srcPath, String descPath){
        File srcFile = new File(srcPath);
        File descFile = new File(descPath);
        FileInputStream fis = null;
        FileOutputStream fos = null;
        long fileSize = srcFile.length();
        try {
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(descFile);

            byte[] buffer = new byte[1024];
            int len;
            while (( len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if ( fis != null){
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return fileSize;
    }

    @Test
    public void testCopy(){
        String srcPath = "/Users/ebaoshuaijia/Public/software/CentOS-8.3.2011-x86_64-dvd1.iso";
        String descPath = "/Users/ebaoshuaijia/Public/temp/1CentOS-8.3.2011-x86_64-dvd1.iso";
        long start = System.currentTimeMillis();
        long fileSize = copyWithInputOutputStreamTest(srcPath, descPath);
        long end = System.currentTimeMillis();
        HashMap<String, String> test = new HashMap<>();
        test.get("");
        System.out.println("复制文件耗时："+(end-start)+"\n文件大小："+(fileSize/1024/1024));
        /**
         * 复制文件耗时：7538
         * 文件大小：8835
         */
    }
}
