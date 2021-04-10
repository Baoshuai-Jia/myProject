package com.jia.springboot.springboothelloworld2.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
public class Pet {
    private String name;
    private Double weight;
}
