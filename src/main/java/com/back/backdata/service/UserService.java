package com.back.backdata.service;

import com.back.backdata.pojo.User;

public interface UserService {
    // 用户注册
    User register(User user) throws RuntimeException;

    // 用户登录
    User login(String studentId, String password) throws RuntimeException;

    // 修改密码
    void changePassword(String studentId, String oldPassword, String newPassword, String confirmPassword) throws RuntimeException;

    // 更新用户信息
    User updateProfile(User user) throws RuntimeException;
}
