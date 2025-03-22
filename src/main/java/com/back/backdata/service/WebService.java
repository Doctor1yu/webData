package com.back.backdata.service;

import com.back.backdata.pojo.Orders;
import com.back.backdata.pojo.User;
import com.back.backdata.pojo.Feedback;
import java.util.List;

public interface WebService {
    // 获取所有功能信息
    List<Orders> getAllOrders();

    // 获取所有用户信息
    List<User> getAllUsers();

    // 获取所有反馈信息
    List<Feedback> getAllFeedbacks();
}
