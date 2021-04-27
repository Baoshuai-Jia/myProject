package com.example.redis02springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Component
@Data
//在企业开发中，pojo都会序列化
public class User implements Serializable {
    private String name;
    private int age;
}
