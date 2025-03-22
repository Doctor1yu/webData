package com.back.backdata.service;

import com.back.backdata.pojo.Orders;
import com.back.backdata.pojo.User;
import java.util.List;

public interface WebService {
    // 获取所有功能信息
    List<Orders> getAllOrders();

    // 获取所有用户信息
    List<User> getAllUsers();
}
