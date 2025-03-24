package com.back.backdata.service.impl;

import com.back.backdata.mapper.UserMapper;
import com.back.backdata.pojo.User;
import com.back.backdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateStatus(String studentId, String status) {
        userMapper.updateStatus(studentId, status);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }

    @Override
    public void resetPassword(String studentId) {
        User user = userMapper.getUserByStudentId(studentId);
        if (user != null) {
            String newPassword = studentId + "abc";  // 使用学号生成新密码
            userMapper.updatePasswordByStudentId(studentId, newPassword);
        }
    }
} 