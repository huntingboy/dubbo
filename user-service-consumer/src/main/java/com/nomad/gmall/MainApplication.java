package com.nomad.gmall;

import com.nomad.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author nomad
 * @Description 服务消费者启动类:1. 导入依赖; 2.配置dubbo consumer, 比如应用名，reference接口等
 * @create 2020-11-30 5:42 PM
 */
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.initOrder("1");

        System.out.println("调用完成...");
        System.in.read();
    }
}
