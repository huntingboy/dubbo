package com.nomad.gmall.service.impl;

import com.nomad.gmall.bean.UserAddress;
import com.nomad.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

/**
 * @author nomad
 * @Description 用户服务实现
 * @create 2020-11-30 4:04 PM
 */
public class UserServiceImpl implements UserService {

    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1, "地址1", "1", "张三", "13813432134", "Y");
        UserAddress address2 = new UserAddress(2, "地址2", "1", "李四", "13813432111", "N");

        return Arrays.asList(address1, address2);
    }
}
