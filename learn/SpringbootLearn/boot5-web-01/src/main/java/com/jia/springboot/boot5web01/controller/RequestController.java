package com.jia.springboot.boot5web01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request){
        request.setAttribute("msg","setAttributeTest");
        request.setAttribute("code",200);
        return "forward:/success";//转发所以请求的参数还有
    }

    @ResponseBody
    @GetMapping("/success")
    public Map success(HttpServletRequest request,
                       @RequestAttribute("msg") String msg){
        Map<String, String> result = new HashMap<>();
        result.put("code",request.getAttribute("code").toString());
        result.put("msg",msg);
        return result;
    }
}
