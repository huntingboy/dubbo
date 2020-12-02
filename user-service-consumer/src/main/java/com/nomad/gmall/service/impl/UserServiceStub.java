package com.nomad.gmall.service.impl;

import com.nomad.gmall.bean.UserAddress;
import com.nomad.gmall.service.UserService;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author nomad
 * @Description 利用本地存根在客户端执行部分逻辑(做 ThreadLocal 缓存，提前验证参数，调用失败后伪造容错数据等),
 * 客户端生成 Proxy 实例，会把 Proxy 通过构造函数传给 Stub 1，然后把 Stub 暴露给用户，Stub 可以决定要不要去调 Proxy
 * @create 2020-12-01 4:08 PM
 */
public class UserServiceStub implements UserService {
    private final UserService userService;

    public UserServiceStub(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("UserServiceStub.getUserAddressList被调用");
        if (!StringUtils.isEmpty(userId)) {
            return userService.getUserAddressList(userId);
        }
        return null;
    }
}
