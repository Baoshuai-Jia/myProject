package com.jia;

import com.jia.bean.Car;
import com.jia.bean.Pet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
//@EnableAutoConfiguration
@SpringBootApplication
@Slf4j
public class Example {

    @Resource
    private Car car;

    @RequestMapping("/")
    String home() {
        return "Hello World! 你好";
    }

    @RequestMapping("/car")
    String car() {
        log.info("请求进来了。。。");
        return car.toString();
    }

    public static void main(String[] args) {
        //1、IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(Example.class, args);
        //2、容器中的组件
//        String[] definitionNames = run.getBeanDefinitionNames();
//        for (int i = 0; i < definitionNames.length; i++) {
//            System.out.println(definitionNames[i]);
//        }
//        //3、从容器中获取组件
//        Object tomcat = run.getBean("tomcat");
//        System.out.println(tomcat);
//
//        Pet tomcat1 = run.getBean("tomcat", Pet.class);
//        System.out.println(tomcat1);
//
//        MyConfig bean = run.getBean(MyConfig.class);

//        System.out.println(run.containsBean("user01"));
        boolean haha = run.containsBean("haha");
        boolean hehe = run.containsBean("hehe");
        System.out.println("haha: " + haha);
        System.out.println(run.getBean("hehe"));
//        System.out.println("hehe: "+hehe);
//        System.exit(0);
    }


}