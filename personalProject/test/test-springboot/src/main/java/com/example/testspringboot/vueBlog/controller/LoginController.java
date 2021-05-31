package com.example.testspringboot.vueBlog.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class LoginController {

    @PostMapping(value = "/login")
    public String login(@RequestBody List<String> params, HttpServletResponse response){
        for (String param : params){
            System.out.println(param);
        }
        return "success";
    }
}
