package com.jia.config;

import com.jia.bean.Car;
import com.jia.bean.Pet;
import com.jia.bean.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

//@Import({User.class})
//@ConditionalOnBean(name = "tomcat")
@Configuration(proxyBeanMethods = false)  //高数SpringBoot这个一个配置类， == 配置文件
@ImportResource("classpath:beans.xml")
@EnableConfigurationProperties(Car.class)//开启配置绑定功能、car注册到容器中
public class MyConfig {

//    @ConditionalOnBean()
//    @Bean //给容器中添加组件。已方法名为组件ID，返回值为组件类型，返回的值是组件在容器中的实例
//    public User user01(){
//        return new User("张三",18);
//    }
//
//    @Bean
//    public Pet tomcat(){
//        return new Pet("tomcat");
//    }
}
