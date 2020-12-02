package com.nomad.gmall;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * 1.导入依赖：dubbo-starter
 * 2.配置dubbo consumer参数，比如暴露服务（ref指向具体实现的service），zk地址，服务名字等
 *
 * springboot和dubbo整合的3种方式：
 * 方式一：导入starter依赖->application.properties配置标签属性—>注解@EnabbleDubbo, @Service, @Reference (推荐)
 * 方式二：导入依赖->保留provider.xml配置的标签属性->@ImportResource导入Dubbo的provider.xml配置文件即可
 * 方式三：导入依赖->api方式配置bean(XxxConfig):@Configuration, @Bean,->@DubboComponentScan或者@EnableDubbo(scanBasePackages = "com.nomad.gmall")
 */
//@ImportResource(locations = "classpath:provider.xml")
@EnableDubbo
@SpringBootApplication
@EnableHystrix //开启hystrix相关注解解析器
//@DubboComponentScan
//@EnableDubbo(scanBasePackages = "com.nomad.gmall")
public class BootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootUserServiceProviderApplication.class, args);
    }

}
