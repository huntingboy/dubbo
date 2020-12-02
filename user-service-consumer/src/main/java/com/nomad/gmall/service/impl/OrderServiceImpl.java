package com.nomad.gmall.service.impl;

import com.nomad.gmall.bean.UserAddress;
import com.nomad.gmall.service.OrderService;
import com.nomad.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nomad
 * @Description 订单服务实现
 * @create 2020-11-30 4:14 PM
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;

    @Override
    public List<UserAddress> initOrder(String userId) {
        System.out.println("userId = " + userId);
        List<UserAddress> userAddressList = userService.getUserAddressList(userId);
        System.out.println(userAddressList);
        //System.out.println(Arrays.toString(userAddressList.toArray()));
        return userAddressList;
    }
}
