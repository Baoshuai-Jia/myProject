package com.example.httpclientdemo.controller;

import com.example.httpclientdemo.pojo.UserRequest;
import com.sun.deploy.net.HttpResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

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
}
