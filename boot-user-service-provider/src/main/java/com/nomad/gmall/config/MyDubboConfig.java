package com.nomad.gmall.config;

import com.alibaba.dubbo.config.*;
import com.nomad.gmall.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nomad
 * @Description API方式配置Dubbo Bean(XxxConfig显式配置)
 * @create 2020-12-01 4:28 PM
 */
/*@Configuration
public class MyDubboConfig {
    @Bean
    public ApplicationConfig applicationConfig(){
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("boot-user-service-provider");
        return applicationConfig;
    }

    @Bean
    public RegistryConfig registryConfig(){
        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setProtocol("zookeeper");
        registryConfig.setAddress("127.0.0.1:2181");
        return registryConfig;
    }

    @Bean
    public ProtocolConfig protocolConfig(){
        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20880);
        return protocolConfig;
    }

    @Bean
    public ServiceConfig<UserService> userServiceServiceConfig(UserService userService) {
        ServiceConfig<UserService> serviceConfig = new ServiceConfig<>();
        serviceConfig.setInterface("com.nomad.gmall.service.UserService");
        serviceConfig.setRef(userService);
        serviceConfig.setVersion("1.0.0");

        //配置每个method的信息
        MethodConfig methodConfig = new MethodConfig();
        methodConfig.setName("getUserAddressList");
        methodConfig.setTimeout(3200);
        methodConfig.setRetries(2);

        //方法和service关联
        List<MethodConfig> methods = new ArrayList<>();
        methods.add(methodConfig);

        serviceConfig.setMethods(methods);

        //关联ProviderConfig;MonitorConfig等

        return serviceConfig;
    }
}*/
