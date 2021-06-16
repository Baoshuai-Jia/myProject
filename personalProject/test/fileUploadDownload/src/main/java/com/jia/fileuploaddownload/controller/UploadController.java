package com.jia.fileuploaddownload.controller;

import com.jia.util.DownloadUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


@RestController
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public void upload(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*"); //最简单的设置跨域 *
        try {
            ServletOutputStream outputStream = res.getOutputStream();
//            File file = new File("/Users/ebaoshuaijia/Downloads/cat (1).mp4");
            File file = new File("/Users/ebaoshuaijia/Downloads/CentOS-8.4.2105-x86_64-dvd1.iso");
//            File file = new File("/Users/ebaoshuaijia/Downloads/VBoxGuestAdditions.iso");
            FileInputStream fileInputStream = new FileInputStream(file);
            IOUtils.copy(fileInputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }

    @RequestMapping("/upload1")
    @ResponseBody
    public void upload1(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*"); //最简单的设置跨域 *
        try {
            ServletOutputStream outputStream = res.getOutputStream();
            String result = DownloadUtils.sliceDownloadFile("/Users/ebaoshuaijia/Downloads/cat (1).mp4", 0, 1024 * 100, outputStream);
            res.setHeader("result",result);
//            File file = new File("/Users/ebaoshuaijia/Downloads/cat (1).mp4");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            IOUtils.copy(fileInputStream,outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }



    @RequestMapping("/test01")
    @ResponseBody
    public String test01(){
        return "test01";
    }








}
