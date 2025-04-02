package com.back.backdata.service.impl;

import com.back.backdata.mapper.UserMapper;
import com.back.backdata.service.ApplicationsService;
import com.back.backdata.mapper.ApplicationsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.back.backdata.pojo.Applications;
import java.sql.Timestamp;

@Service
public class ApplicationsServiceImpl implements ApplicationsService {
    
    @Autowired
    private ApplicationsMapper applicationsMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateApplicationStatus(String studentId, String status, String remark, String reviewerName, Timestamp reviewedAt) {
        // 更新申请状态
        Applications application = new Applications();
        application.setStudentId(studentId);
        application.setStatus(status);
        application.setRemark(remark);
        application.setReviewerName(reviewerName);
        application.setReviewedAt(reviewedAt);
        
        applicationsMapper.updateApplication(application);

        // 如果状态为通过（3），更新用户角色
        if ("3".equals(status)) {
            userMapper.updateUserRole(studentId, 2);
        }
    }
}
