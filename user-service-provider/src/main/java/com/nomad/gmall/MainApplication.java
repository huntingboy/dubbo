package com.nomad.gmall;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author nomad
 * @Description 服务提供者启动类:1.配置dubbo, curator zkcient ; 2.dubbo配置，比如暴露服务（ref指向具体实现的service），zk地址，服务名字等
 * @create 2020-11-30 5:07 PM
 */
public class MainApplication {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("provider.xml");
        ioc.start();

        System.in.read();
    }
}
