package com.jia.fileuploaddownload.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;


@RestController
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(HttpServletResponse res){
        res.setHeader("Access-Control-Allow-Origin", "*"); //最简单的设置跨域 *
//        try {
//            ServletOutputStream outputStream = res.getOutputStream();
//            File file = new File("/Users/ebaoshuaijia/Downloads/cat (1).mp4");
//            FileInputStream fileInputStream = new FileInputStream(file);
//            IOUtils.copy(fileInputStream,outputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//        }
        return "hello wendy";
    }


    @RequestMapping("/test01")
    @ResponseBody
    public String test01(){
        return "test01";
    }








}
