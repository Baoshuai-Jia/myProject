package com.jia.Chapater13.io;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 * 1.直接继承java.lang.Object，同时实现了DataInput和DataOutput
 * 2。RandomAccessFile 既可以读取文件也可以写入文件(既是输入流又是输出流)
 * 3。输出流时，如果文件内容不存在，则自动创建文件 knowledge
 */
public class RandomAccessFileTest {
    
    @Test
    public void test01(){
        RandomAccessFile raf_r = null;
        RandomAccessFile raf_w = null;
        try {
            raf_r = new RandomAccessFile(new File("xiaowu.png"),"r");
            raf_w = new RandomAccessFile(new File("xiaowu4.png"),"rw");
            byte[] buffer = new byte[5];
            int len;
            while ((len = raf_r.read(buffer)) != -1){
                raf_w.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf_r != null){
                try {
                    raf_r.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf_w != null){
                try {
                    raf_w.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Test
    public void test02(){
        //读原有文件内容进行覆盖跟新
        //helloWorld123贾宝帅文迪
        RandomAccessFile rwd = null;
        try {
            rwd = new RandomAccessFile(new File("hello.txt"), "rwd");
            rwd.write("abc".getBytes());//abcloWorld123贾宝帅文迪

            //设置插入覆盖的位置
            rwd.seek(5);
            rwd.write("Wendy".getBytes());//abcloWendy123贾宝帅文迪
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rwd != null)
                rwd.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
