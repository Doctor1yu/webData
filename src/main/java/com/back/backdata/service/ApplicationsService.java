package com.back.backdata.service;

import java.sql.Timestamp;

public interface ApplicationsService {
    void updateApplicationStatus(String studentId, String status, String remark, String reviewerName, Timestamp reviewedAt);
}
