package com.back.backdata.service;

import com.back.backdata.pojo.HomeData;
import com.back.backdata.pojo.OrderStatusStats;
import com.back.backdata.pojo.FeedbackStats;

public interface HomeService {
    HomeData getHomeData();
    OrderStatusStats getOrderStatusStats();
    FeedbackStats getFeedbackStats();
}
