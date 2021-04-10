package com.jia.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mycar")
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
//@ArgsAttributes()
public class Car {
    private String bride;
    private Integer price;


}
