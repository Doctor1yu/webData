package com.back.backdata.service;

import java.sql.Timestamp;

public interface ApplicationsService {
    void updateApplicationStatus(int id, String status, String remark, String reviewerName, Timestamp reviewedAt);
    
    // 获取申请中的收款码URL
    String getCollectUrlById(int id);
}
