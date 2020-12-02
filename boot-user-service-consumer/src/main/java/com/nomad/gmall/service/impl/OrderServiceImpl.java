package com.nomad.gmall.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nomad.gmall.bean.UserAddress;
import com.nomad.gmall.service.OrderService;
import com.nomad.gmall.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author nomad
 * @Description 订单服务实现
 * @create 2020-11-30 4:14 PM
 */
@Service
public class OrderServiceImpl implements OrderService {

    //loadbalance:负载均衡策略，默认"random" 加权随机负载均衡呢策略(对应1个接口的具体实现RandomLoadBalance,
    // 还有RoundRobinLoadBalance加权论询负载策略，LeastActiveLoadBalance最小负载/连接策略)
    //cluster:集群容错模式：
    //  failover(默认，用于幂等性服务，失败则自动切换，通常配合retries来设置1个service的重试次数)
    //  failfast(快速失败，失败立即报错，非幂等性服务，比如写)
    //  failsafe(失败安全，异常直接忽略，写入日志)
    //  failback(失败自动恢复，后台记录失败请求，定时重发)
    //  forking(并行调用多个服务器，一个成功就成功，实时性，结合forks=2设置并行数)
    //  broadcast(广播调用所有服务提供者，一个失败就失败，比如更新本地缓存、日志等)
    //url:dubbo直连，zk宕机后仍可通过本地缓存或者直连方式调用服务提供方
    //@Reference(url = "127.0.0.1:20880",version = "1.0.0", timeout = 5000)
    @Reference(version = "1.0.0", timeout = 5000, loadbalance = "roundrobin", cluster = "failover")
    UserService userService;

    @HystrixCommand(fallbackMethod = "hello") //调用发生异常后，转去调用本地方法hello
    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId = " + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
        //System.out.println(Arrays.toString(userAddressList.toArray()));

        return userAddressList;
    }

    public List<UserAddress> hello(String userId) {
        return Arrays.asList(new UserAddress(20, "hystrix测试==fallbackMethod", "测试", "1", "phoneNUm", "N"));
    }
}
