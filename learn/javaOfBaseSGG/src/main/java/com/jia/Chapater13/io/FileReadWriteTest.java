package com.jia.Chapater13.io;

import org.junit.Test;

import java.io.*;

/**
 * 1.流的分类
 *  按照流的流向： 输入流、 输出流
 *  按照流的单位： 字节流、 字符流
 *  按照流的角色：节点流、处理流
 *
 *  2、流的体系结构
 *
 *  基类                  节点流（文件流）                缓冲流
 *  InputStream         FileInputStream             BufferedInputStream
 *  OutputStream        FileOutputStream            BufferedOutputStream
 *  Reader              FileReader                  BufferedReader
 *  Writer              FileWriter                  bufferedWriter
 */
public class FileReadWriteTest {
    public static void main(String[] args) {
        File file = new File("hello.txt");
        System.out.println(file.getAbsolutePath());//相对与当前工程，父工程pom所在的文件夹
    }

    /**
     * 将当前项目下的hello。txt读取到内存中， 打印到控制台
     */
    @Test
    public void testFileReader() throws IOException {
        File file = new File("hello.txt");

        FileReader fileReader = new FileReader(file);

        //读取一个字符对应的int值，如果返回 -1 证明读取结束
        //方式一：
//        int data = fileReader.read();
//        while (data != -1){
//            System.out.print((char) data);
//            data = fileReader.read();
//        }
        //方式二：语法上修改
        int data;
        while ((data = fileReader.read()) != -1){
            System.out.print((char) data);
        }

        //
        fileReader.close();
    }

    @Test
    public void testFileReader1(){
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");

            fileReader = new FileReader(file);

            char[] cbuf = new char[5];
            int len;
            //read(char[] cbuf)) 返回读取到的字符个数，如果到结尾返回 -1
            while ((len = fileReader.read(cbuf)) != -1){
                //错误写法  helloWorld123ld
//                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }
                //正确写法 helloWorld123
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 从内存中写出数据到硬盘里
     * new FileWriter(file,false) 文件不存在会自动创建文件
     *  如果存在可以使用第二个参数觉得： 是追加文件内容还是清空文件重写
     */
    @Test
    public void fileWriterTest() throws IOException {
        File file = new File("hello1.txt");

        FileWriter fileWriter = new FileWriter(file,false);

        fileWriter.write("I have a dream! \n");
//        fileWriter.write("You need to have a dream !");

        fileWriter.close();
    }

    @Test
    public void fileReaderAndWriterTest(){
        FileReader fileReader = null;
        FileWriter fileWriter = null;
        try {
            File sourceFile = new File("hello.txt");
            File descFile = new File("hello2.txt");

            fileReader = new FileReader(sourceFile);
            fileWriter = new FileWriter(descFile);

            char[] cbuf = new char[5];
            int len ;
            while ((len = fileReader.read(cbuf)) != -1){
                fileWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null){
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
