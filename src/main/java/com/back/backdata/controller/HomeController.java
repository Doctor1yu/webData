package com.back.backdata.controller;

import com.back.backdata.pojo.HomeData;
import com.back.backdata.pojo.OrderStatusStats;
import com.back.backdata.pojo.FeedbackStats;
import com.back.backdata.pojo.Result;
import com.back.backdata.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private HomeService homeService;

    @GetMapping("/count")
    public Result getHomeData() {
        HomeData homeData = homeService.getHomeData();
        return Result.success(homeData);
    }

    @GetMapping("/count/last30days")
    public Result getOrderStatusStats() {
        OrderStatusStats stats = homeService.getOrderStatusStats();
        return Result.success(stats);
    }

    @GetMapping("/feedback/stats")
    public Result getFeedbackStats() {
        FeedbackStats stats = homeService.getFeedbackStats();
        return Result.success(stats);
    }
}