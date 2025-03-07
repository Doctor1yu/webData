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
    public User register(User user) throws RuntimeException {
        // 检查必填项
        if (user.getStudentId() == null || user.getStudentId().isEmpty()) {
            throw new RuntimeException("学号不能为空");
        }
        if (user.getNickName() == null || user.getNickName().isEmpty()) {
            throw new RuntimeException("昵称不能为空");
        }
        if (user.getPhoneNumber() == null || user.getPhoneNumber().isEmpty()) {
            throw new RuntimeException("手机号不能为空");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new RuntimeException("密码不能为空");
        }
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            throw new RuntimeException("确认密码不能为空");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            throw new RuntimeException("密码和确认密码不一致");
        }

        // 检查学号是否已存在
        User existingUser = userMapper.findUserByStudentId(user.getStudentId());
        if (existingUser != null) {
            throw new RuntimeException("该学号已注册");
        }
        // 插入新用户
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public User login(String studentId, String password) throws RuntimeException {
        User user = userMapper.findUserByStudentId(studentId);
        if (user == null || !user.getPassword().equals(password)) {
            throw new RuntimeException("学号或密码错误");
        }
        return user;
    }

    @Override
    public void changePassword(String studentId, String oldPassword, String newPassword, String confirmPassword) throws RuntimeException {
        // 检查新密码和确认密码是否一致
        if (!newPassword.equals(confirmPassword)) {
            throw new RuntimeException("新密码和确认密码不一致");
        }

        // 查询用户信息
        User user = userMapper.findUserByStudentId(studentId);
        if (user == null || !user.getPassword().equals(oldPassword)) {
            throw new RuntimeException("原密码错误");
        }

        // 更新密码
        userMapper.updatePassword(studentId, newPassword);
    }

    @Override
    public User updateProfile(User user) throws RuntimeException {
        userMapper.updateProfile(user);
        return userMapper.findUserByStudentId(user.getStudentId());
    }
}
