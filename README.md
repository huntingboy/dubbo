### Dubbo sgg视频（orderService.xXX()->userService.xXX() rpc示例）的学习笔记总结

[详细使用参见：dubbo 官方手册](http://dubbo.apache.org/zh/docs/v2.7/user/quick-start/)

1. 角色：provider(服务提供/暴露者), consumer(服务消费/引用者), zk(注册中心，服务注册与发现), dubbo-admin(web ui管理界面)

2. gmall：父模块，统一管理所有子模块的依赖版本等信息

3. 常规使用：

   - 1.导入依赖; 2.配置dubbo consumer/provider, 比如应用名，reference/service接口及实现等(常用xml配置标签参考[Dubbo 的 XML Schema 配置参考手册](http://dubbo.apache.org/zh/docs/v2.7/user/references/xml/))

   - gmall-interface：定义公共接口，统一管理，provider/consumer需要就导入pom.xml，避免重复和维护。
   - user-service-provider：服务提供者，service层提供一个获取用户地址函数。
   - user-service-consumer：服务消费者，service层使用一个订单函数通过服务接口代理调用上述获取用户地址的函数。

4. 与SpringBoot整合使用(要注意依赖版本)：

   - 方式一：导入starter依赖->application.properties配置标签属性()—>注解@EnabbleDubbo, @Service, @Reference (推荐)
   - 方式二：导入依赖->保留provider.xml配置的标签属性->@ImportResource导入Dubbo的provider.xml配置文件即可
   - 方式三：导入依赖->api方式配置bean(XxxConfig):@Configuration, @Bean,->@DubboComponentScan或者@EnableDubbo(scanBasePackages = "com.nomad.gmall")
   - gmall-interface：定义公共接口，统一管理，provider/consumer需要就导入pom.xml，避免重复和维护。
   - boot-user-service-provider：服务提供者，service层提供一个获取用户地址函数。
   - boot-user-service-consumer：服务消费者，service层使用一个订单函数通过服务接口代理调用上述获取用户地址的函数。

5. 使用

   - 标签属性优先级(a. -Dxxx > application.properties > dubbo.xml > dubbo.properties；b. 精确匹配优先(接口属性>reference标签属性>consumer标签属性)；c. 相同级别，provider<consumer)
   - 常用用法([用法示例](http://dubbo.apache.org/zh/docs/v2.7/user/examples/): 启动时检查，服务超时时间，负载均衡，直连provider，多版本灰度发布，参数验证本地存根，集群容错，整合hystrix实现服务降级和容错即高可用)
   - 标签属性(check, timeout, loadbalance, url, version, 自定义实现公共接口的stub, cluster, @EnableHystrix+@HystrixCommand(fallbackMethod=xxx))使用

6. 源码解析

   - rpc及netty([netty笔记](https://github.com/huntingboy/netty))

   - 设计图解

     - 整体设计
       <img src="pic/dubbo-framework.jpg" style="zoom: 80%;" />
     - 模块分包
       <img src="pic/dubbo-modules.jpg" style="zoom:80%;" />
     - 依赖关系<img src="/home/gao/.config/Typora/typora-user-images/image-20201202143811805.png" style="zoom:80%;" />
     - 标签解析(DubboBeanDefinitionParser类, XxxConfig类)
     - 调用链
       <img src="pic/dubbo-extension.jpg" style="zoom:80%;" />
     - 暴露服务时序
       <img src="pic/dubbo-export.jpg" style="zoom:80%;" />
     - 引用服务时序
       <img src="pic/dubbo-refer.jpg" style="zoom:80%;" />

