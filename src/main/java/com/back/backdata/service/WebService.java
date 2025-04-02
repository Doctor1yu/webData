package com.back.backdata.service;

import com.back.backdata.pojo.Applications;
import com.back.backdata.pojo.Orders;
import com.back.backdata.pojo.User;
import com.back.backdata.pojo.Feedback;
import com.back.backdata.pojo.Rotation;
import java.util.List;

public interface WebService {
    // 获取所有功能信息
    List<Orders> getAllOrders();

    // 获取所有用户信息
    List<User> getAllUsers();

    // 获取所有反馈信息
    List<Feedback> getAllFeedbacks();

    // 获取所有申请信息
    List<Applications> getAllApplications();

    // 获取所有轮播图信息
    List<Rotation> getAllRotations();
}
