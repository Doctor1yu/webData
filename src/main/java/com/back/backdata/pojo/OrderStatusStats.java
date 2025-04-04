package com.back.backdata.pojo;

import lombok.Data;

@Data
public class OrderStatusStats {
    private Integer pendingCount;    // 未接单数量 (status = 1)
    private Integer processingCount; // 进行中数量 (status = 2)
    private Integer completedCount;  // 已完成数量 (status = 3)
} 