package com.back.backdata.pojo;

import lombok.Data;

@Data
public class FeedbackStats {
    private Integer courierIssueCount;     // 快递员问题数量
    private Integer platformIssueCount;    // 平台问题数量
    private Integer deliveryTimeCount;     // 送货时间安排数量
    private Integer paymentIssueCount;     // 金额问题数量
    private Integer otherIssueCount;       // 其他问题数量
} 