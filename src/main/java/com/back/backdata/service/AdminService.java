package com.back.backdata.service;

import com.back.backdata.pojo.Admin;
import java.util.List;

public interface AdminService {
    // 管理员登录
    Admin loginAdmin(String username, String password);

    // 更新管理员密码
    void updateAdminPassword(Integer id, String oldPassword, String newPassword);

    // 根据ID查询管理员信息
    Admin findById(Integer id);

    // 根据用户名查询管理员信息
    Admin findByUsername(String username);

    // 获取所有管理员信息
    List<Admin> getAllAdmins();
    
    // 添加管理员
    void addAdmin(String username, String password);

    // 根据ID删除管理员
    void deleteAdminById(Integer id);
} 