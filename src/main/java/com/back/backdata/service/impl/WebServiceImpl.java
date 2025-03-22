package com.back.backdata.service.impl;

import com.back.backdata.mapper.WebMapper;
import com.back.backdata.pojo.Orders;
import com.back.backdata.pojo.User;
import com.back.backdata.pojo.Feedback;
import com.back.backdata.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private WebMapper webMapper;

    // 获取所有功能信息
    @Override
    public List<Orders> getAllOrders() {
        return webMapper.getAllOrders();
    }

    // 获取所有用户信息
    @Override
    public List<User> getAllUsers() {
        return webMapper.getAllUsers();
    }

    // 获取所有反馈信息
    @Override
    public List<Feedback> getAllFeedbacks() {
        return webMapper.getAllFeedbacks();
    }
}
