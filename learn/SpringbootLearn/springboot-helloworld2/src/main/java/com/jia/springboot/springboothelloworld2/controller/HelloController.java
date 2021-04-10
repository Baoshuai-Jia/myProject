package com.jia.springboot.springboothelloworld2.controller;

import com.jia.springboot.springboothelloworld2.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private Person person;

    @RequestMapping("/person")
    public Person person(){
        return person;
    }
}
