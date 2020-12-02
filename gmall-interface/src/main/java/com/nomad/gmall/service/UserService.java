package com.nomad.gmall.service;

import com.nomad.gmall.bean.UserAddress;

import java.util.List;

/**
 * @author nomad
 * @Description 用户服务
 * @create 2020-11-30 4:03 PM
 */
public interface UserService {
    /**
     * 根据用户id得到用户所有收货地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
