package com.example.httpclientdemo.controller;

import com.example.httpclientdemo.pojo.*;
import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.nio.ch.IOUtil;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;

@RestController
public class UserController {

    @RequestMapping("/test1")
    public String test1(UserRequest userRequest, HttpServletRequest request){
        System.out.println("业务参数 ： "+userRequest);
        final Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            System.out.println(headName+" : "+request.getHeader(headName));
        }
        return "test01";
    }

    @RequestMapping("/test2")
    public String test2(@RequestBody UserRequest userRequest, HttpServletRequest request){
        System.out.println("业务参数 ： "+userRequest);
        final Enumeration<String> headerNames = request.getHeaderNames();

        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            System.out.println(headName+" : "+request.getHeader(headName));
        }
        return "test02";
    }

    @RequestMapping("/test3")
    public String test3(@RequestParam("fileName") MultipartFile[] files,  UserRequest userRequest, HttpServletRequest request){
        System.out.println("业务参数 ： "+userRequest);
        final Enumeration<String> headerNames = request.getHeaderNames();
        for (MultipartFile file: files){
            System.out.println("要上传的文件名： "+file.getOriginalFilename());
        }
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            System.out.println(headName+" : "+request.getHeader(headName));
        }
        return "test03";
    }

    @RequestMapping(value = "/jes/findOnNode.html")
    @ResponseBody
    public ResultMsg findOnNode(@RequestBody HttpClientNode node, HttpServletResponse response){
        File file = new File(node.getFile());
        boolean exists = file.exists();
        HashMap<String, Object> msg = new HashMap<String, Object>();
        if (exists){
            msg.put("exists",exists);
            boolean isFile = file.isFile();
            if (isFile){
                msg.put("list", Arrays.asList(file.getPath()));
            }else {
                msg.put("list",file.list());
            }
        }

        return new ResultMsg(true,msg);
    }

    @RequestMapping(value = "/jes/downloadFileFromNode.do")
    @ResponseBody
    public ResultMsg downloadFileFromNode(@RequestBody HttpClientNode node, HttpServletResponse response)  {
        File file = new File(JavaScriptAESUtil.decrypt(node.getFile()));
        FileInputStream fileInputStream = null;
        boolean exists = file.exists();
        HashMap<String, Object> msg = null;
        try {
            msg = new HashMap<String, Object>();
            boolean isFile = false;
            if (exists){//存在
                isFile = file.isFile();
                if (isFile){//存在并且是文件
                    fileInputStream = new FileInputStream(file);
                    ServletOutputStream outputStream = response.getOutputStream();
                    DownloadUtil.makeResponseHeader(response,file.getName());
                    IOUtils.copy(fileInputStream,outputStream);
                    response.flushBuffer();
                    outputStream.close();
                }
            }
            if (!isFile){
                //文件不存在或者是个目录  fileName = fileNotFound.txt
                fileInputStream = new FileInputStream(file);
                ServletOutputStream outputStream = response.getOutputStream();
                DownloadUtil.makeResponseHeader(response,"fileNotFound.txt");
                IOUtils.copy(fileInputStream,outputStream);
                response.flushBuffer();
                outputStream.close();
            }
        } catch (IOException e) {
//            logger.error("下载文件异常",e);
        } finally {
//            IOUtil.close  Quietly(fileInputStream);
        }
        return null;
    }


    public static void main(String[] args) {
        File file = new File("/Users/ebaoshuaijia/Public/vscode-server/code/myProVscode/myProject/learn/httpclient/httpclient-demo/src/main/java/com/example/httpclientdemo");
        System.out.println(file.length());
    }
}
