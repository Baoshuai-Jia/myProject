package com.example.testspringboot.controller;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.omg.CORBA.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@RestController
public class StreamServerController {

    @GetMapping("/download")
    public void download(HttpServletResponse response,HttpServletRequest request) throws Exception {
        File file = new File("Users/ebaoshuaijia/Downloads");
        BufferedInputStream bi = new BufferedInputStream(new FileInputStream(file));
        ServletOutputStream outputStream = response.getOutputStream();


    }
}
