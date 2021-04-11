package com.jia.springboot.boot5web01.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParameterController {

    @GetMapping("/car/{id}/owner/{userName}")
    public Map<String, Object> getCar(@PathVariable("id") String id, @PathVariable("userName") String name,
                                      @PathVariable Map<String, String> params, @RequestHeader Map<String, String> headers,
                                      @RequestHeader("Referer") String host, @RequestParam("age") int age
                                      ,@CookieValue("clientVIp") String  _ga
                                      ,@CookieValue("clientVIp") Cookie cookie
                                      , HttpServletRequest request, HttpServletResponse response
                                      ){
        HashMap<String, Object> result = new HashMap<>();
        result.put("id",id);
        result.put("name",name);
        result.put("params",params);
        result.put("host",host);
        result.put("headers",headers);
        result.put("age",age);
//        result.put("_ga" ,_ga);
        return result;
    }

    @PostMapping("/save")
    public String save(@RequestBody String params){
//        System.out.println(params.size());
        return "success";
    }

    // /cars/shell;low=34;brand=byd,audi,yd
    @GetMapping("/cars/{path}")
    public Map cars(@MatrixVariable("low") Integer low, @MatrixVariable("brand") List<String> brand,
                    @PathVariable("path") String path){
        HashMap<String, Object> result = new HashMap<>();
        result.put("low",low);
        result.put("brand",brand);
        result.put("path",path);
        return result;
    }
}
