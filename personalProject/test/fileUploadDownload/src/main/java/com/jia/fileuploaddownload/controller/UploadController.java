package com.jia.fileuploaddownload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(){
        return "hello wendy";
    }
}
