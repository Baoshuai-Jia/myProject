package com.jia.util;

import java.io.*;

public class DownloadUtils {

    public static String sliceDownloadFile(String absolutePath,int startPos, int endPos,OutputStream os) throws IOException {
        String result = "reading";
        RandomAccessFile raf = new RandomAccessFile(absolutePath,"r");
        raf.seek(startPos);
        long length = raf.length();
        if (length < endPos){
            endPos = (int) length;
            result = "end";
        }
        int endLen;//最后一次读取长度
        byte[] buffer = new byte[1024];//读取存放位置
        int readTimes;//读取次数
        readTimes = (endPos - startPos)/1024;
        endLen = (endPos - startPos)%1024;

        for (int i = 0; i < readTimes; i++) {
            raf.read(buffer,i*1024,1024);
            os.write(buffer);
        }
//        raf.re
        return result;
    }
}
