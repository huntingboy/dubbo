package com.nomad.gmall.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.nomad.gmall.bean.UserAddress;
import com.nomad.gmall.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author nomad
 * @Description 用户服务实现
 * @create 2020-11-30 4:04 PM
 */
//和consumer一样，也可以配置loadbalance、cluster等属性，同级别优先级<consumer
//cluster:集群容错模式：
//  failover(默认，用于幂等性服务，失败则自动切换，通常配合retries来设置1个service的重试次数)
//  failfast(快速失败，失败立即报错，非幂等性服务，比如写)
//  failsafe(失败安全，异常直接忽略，写入日志)
//  failback(失败自动恢复，后台记录失败请求，定时重发)
//  forking(并行调用多个服务器，一个成功就成功，实时性，结合forks=2设置并行数)
//  broadcast(广播调用所有服务提供者，一个失败就失败，比如更新本地缓存、日志等)
@Service(version = "1.0.0", timeout = 5000/*, loadbalance = "roundrobin"*/) //暴露服务
@Component
public class UserServiceImpl implements UserService {

    @HystrixCommand
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "地址1", "1", "张三", "13813432134", "Y");
        UserAddress address2 = new UserAddress(2, "地址2", "1", "李四", "13813432111", "N");

        if (Math.random() > 0.5) {
            throw new RuntimeException();
        }
        return Arrays.asList(address1, address2);
    }
}
