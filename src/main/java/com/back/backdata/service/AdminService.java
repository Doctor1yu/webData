package com.back.backdata.service;

import com.back.backdata.pojo.Admin;

public interface AdminService {
    /**
     * 管理员登录接口
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回管理员信息
     * @throws RuntimeException 登录失败抛出异常
     */
    Admin loginAdmin(String username, String password);

    void updateAdminPassword(Integer id, String oldPassword, String newPassword);

    Admin findById(Integer id);

    Admin findByUsername(String username);
} 