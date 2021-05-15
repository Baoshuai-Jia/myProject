package com.jia.producer;

import com.jia.producer.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootOrderRabbitmqProducerApplicationTests {

    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
        orderService.makeDirectOrder();
    }
    @Test
    void contextLoads1() {
        orderService.makeTopicOrder();
    }

}
