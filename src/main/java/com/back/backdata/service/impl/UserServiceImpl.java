package com.back.backdata.service.impl;

import com.back.backdata.mapper.UserMapper;
import com.back.backdata.pojo.User;
import com.back.backdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updatePassword(int id, String newPassword) {
        userMapper.updatePassword(id, newPassword);
    }

    @Override
    public void updateStatus(int id, String status) {
        userMapper.updateStatus(id, status);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteUser(id);
    }
} 