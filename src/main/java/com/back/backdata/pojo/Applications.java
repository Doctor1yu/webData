package com.back.backdata.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Applications {
    private int id; // 用户ID
    private String studentId; // 申请人学号
    private String applyReason; // 申请理由
    private String status; //申请状态（1代表已申请，2代表未申请，3代表通过，4代表拒绝）
    private String reviewerName; // 审核人用户名
    private String remark; // 审核备注
    private Timestamp appliedAt; // 申请时间
    private Timestamp reviewedAt; // 审核时间
}
