package com.jia.Chapater13.io;

import org.junit.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 处理流之一：
 * 1。缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedWriter
 * BufferedReader
 * 2。作用：提升读取、写入的速度
 */
public class BufferedTest {

    @Test
    public void bufferedStreamTest(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("xiaowu.png");
            File descFile = new File("xiaowu3.png");
            //2。造文件流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(descFile);
            //3。造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4。复制文件
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5。关闭流 ;理论：先关闭外层的流， 在关闭内层的流；
            //实际上：当关闭外层的流的时候，内层的流会自动关闭
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (bos != null){
                        try {
                            bos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //实现文件复制功能
    public long copyFileWithBufferedStream(String srcPath, String descPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        long fileSize = 0;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            fileSize = srcFile.length();
            File descFile = new File(descPath);
            //2。造文件流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(descFile);
            //3。造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //4。复制文件
            byte[] buffer = new byte[1024*1024*10];
            int len;
            while ((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //5。关闭流 ;理论：先关闭外层的流， 在关闭内层的流；
            //实际上：当关闭外层的流的时候，内层的流会自动关闭
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (bos != null){
                        try {
                            bos.close();
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
        long fileSize = copyFileWithBufferedStream(srcPath, descPath);
        long end = System.currentTimeMillis();
        System.out.println("复制文件耗时："+(end-start)+"\n文件大小："+(fileSize/1024/1024));
        /**
         * 每次读取的字节数字越小，倍数差的越大
         *
         * 没有使用Buffered的流
         * 复制文件耗时：50116
         * 文件大小：8835
         *
         * 使用了Buffered的流
         * 复制文件耗时：13216
         * 文件大小：8835
         */
    }


    @Test
    public void bufferWriterReaderTest(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File("hello.txt")));
            bw = new BufferedWriter(new FileWriter(new File("hello1.txt")));
            //方式一：使用char数组
//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = br.read(cbuf)) != -1){
//                bw.write(cbuf,0,len);
//            }

            //方式二： 使用String
            String data = null;
            while ((data = br.readLine()) != null){
                //换行方式一：
//                bw.write(data+"\n");//data中不包含换行符
                //换行方式二：
                bw.write(data);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (bw != null){
                        try {
                            bw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    //转换流： utf8 转换成gbk
    @Test
    public void testTransformStream(){
        InputStreamReader isr= null;
        OutputStreamWriter osw = null;

        try {
            FileInputStream fis = new FileInputStream(new File("hello.txt"));
            FileOutputStream fos = new FileOutputStream(new File("hello-gbk.txt"));
            isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            osw = new OutputStreamWriter(fos, "gbk");
            char[] cbuf = new char[5];
            int len;
            while ((len = isr.read(cbuf)) != -1){
                osw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (isr != null){
                try {
                    isr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (osw != null){
                        try {
                            osw.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                test(Thread.currentThread().getName());
            }
        };
        new Thread(runnable,"thread01").start();
        new Thread(runnable,"thread02").start();
    }
    public static void test(String name){
        System.out.println(name);
        int count = 0;
        for (int i = 0; i < 1000*1000*1000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
