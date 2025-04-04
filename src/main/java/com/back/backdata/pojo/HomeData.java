package com.back.backdata.pojo;

import lombok.Data;

@Data
public class HomeData {
    private Integer orderCount;      // 订单总数
    private Integer userCount;       // 用户总数
    private Integer applyCount;      // 申请接单数
    private Integer feedbackCount;   // 反馈数
    private Integer rotationCount;  // 轮播图数量
} 