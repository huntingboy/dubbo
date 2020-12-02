package com.nomad.gmall.service;

import com.nomad.gmall.bean.UserAddress;

import java.util.List;

/**
 * @author nomad
 * @Description 订单服务
 * @create 2020-11-30 4:13 PM
 */
public interface OrderService {
    /**
     * 初始化订单
     * @param userId
     */
    public List<UserAddress> initOrder(String userId);
}
