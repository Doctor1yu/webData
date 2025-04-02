package com.back.backdata.controller;

import com.back.backdata.pojo.*;
import com.back.backdata.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebController {

    @Autowired
    private WebService webService;

    //获取所有订单参数
    @GetMapping("/orders")
    public Result<List<Orders>> getAllFunctions() {
        List<Orders> orders = webService.getAllOrders();
        return Result.success(orders);
    }

    //获取所有用户列表
    @GetMapping("/users")
    public Result<List<User>> getAllUsers() {
        List<User> users = webService.getAllUsers();
        return Result.success(users);
    }

    // 获取所有反馈列表
    @GetMapping("/feedbacks")
    public Result<List<Feedback>> getAllFeedbacks() {
        List<Feedback> feedbacks = webService.getAllFeedbacks();
        return Result.success(feedbacks);
    }

    // 获取所有申请列表
    @GetMapping("/applications")
    public Result<List<Applications>> getAllApplications() {
        List<Applications> applications = webService.getAllApplications();
        return Result.success(applications);
    }

    // 获取所有轮播图列表
    @GetMapping("/rotations")
    public Result<List<Rotation>> getAllRotations() {
        List<Rotation> rotations = webService.getAllRotations();
        return Result.success(rotations);
    }
}
