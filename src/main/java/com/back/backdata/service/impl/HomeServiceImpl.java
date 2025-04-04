package com.back.backdata.service.impl;

import com.back.backdata.pojo.HomeData;
import com.back.backdata.pojo.OrderStatusStats;
import com.back.backdata.pojo.FeedbackStats;
import com.back.backdata.mapper.HomeMapper;
import com.back.backdata.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeServiceImpl implements HomeService {

    @Autowired
    private HomeMapper homeMapper;

    @Override
    public HomeData getHomeData() {
        HomeData homeData = new HomeData();
        homeData.setOrderCount(homeMapper.getOrderCount());
        homeData.setUserCount(homeMapper.getUserCount());
        homeData.setApplyCount(homeMapper.getApplyCount());
        homeData.setFeedbackCount(homeMapper.getFeedbackCount());
        homeData.setRotationCount(homeMapper.getCarouselCount());
        return homeData;
    }

    @Override
    public OrderStatusStats getOrderStatusStats() {
        OrderStatusStats stats = new OrderStatusStats();
        stats.setPendingCount(homeMapper.getPendingOrderCount());
        stats.setProcessingCount(homeMapper.getProcessingOrderCount());
        stats.setCompletedCount(homeMapper.getCompletedOrderCount());
        return stats;
    }

    @Override
    public FeedbackStats getFeedbackStats() {
        FeedbackStats stats = new FeedbackStats();
        stats.setCourierIssueCount(homeMapper.getCourierIssueCount());
        stats.setPlatformIssueCount(homeMapper.getPlatformIssueCount());
        stats.setDeliveryTimeCount(homeMapper.getDeliveryTimeCount());
        stats.setPaymentIssueCount(homeMapper.getPaymentIssueCount());
        stats.setOtherIssueCount(homeMapper.getOtherIssueCount());
        return stats;
    }
}
