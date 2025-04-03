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
    public void updateApplicationStatus(int id, String status, String remark, String reviewerName, Timestamp reviewedAt) {
        // 更新申请状态
        Applications application = new Applications();
        application.setId(id);
        application.setStatus(status);
        application.setRemark(remark);
        application.setReviewerName(reviewerName);
        application.setReviewedAt(reviewedAt);
        
        applicationsMapper.updateApplication(application);

        // 根据studentId更新用户表中的applicationStatus
        String studentId = applicationsMapper.getStudentIdById(id);
        userMapper.updateUserApplicationStatus(studentId, status);

        // 如果状态为同意（3），更新用户角色为2；如果状态为拒绝（4），更新用户角色为1
        if ("3".equals(status)) {
            userMapper.updateUserRole(studentId, 2);
        } else if ("4".equals(status)) {
            userMapper.updateUserRole(studentId, 1);
        }
    }
}
