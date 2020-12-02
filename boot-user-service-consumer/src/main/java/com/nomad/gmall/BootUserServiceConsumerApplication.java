package com.nomad.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 1.导入依赖：dubbo-starter
 * 2.配置dubbo consumer参数
 */
@EnableDubbo
@SpringBootApplication
@EnableHystrix
public class BootUserServiceConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceConsumerApplication.class, args);
    }

}
