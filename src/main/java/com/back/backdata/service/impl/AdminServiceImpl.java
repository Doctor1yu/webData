package com.back.backdata.service.impl;

import com.back.backdata.pojo.Admin;
import com.back.backdata.mapper.AdminMapper;
import com.back.backdata.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    // 管理员登录
    @Override
    public Admin loginAdmin(String username, String password) throws RuntimeException {
        // 查询用户
        Admin admin = adminMapper.findByUsername(username);
        
        // 验证用户存在性和密码
        if(admin == null || !admin.getPassword().equals(password)) {
            throw new RuntimeException("用户名或密码错误");
        }

        return admin;
    }

    @Override
    public void updateAdminPassword(Integer id, String oldPassword, String newPassword) {
        // 查询用户信息
        Admin admin = adminMapper.findById(id);
        // 验证旧密码
        if(!admin.getPassword().equals(oldPassword)) {
            throw new RuntimeException("原密码错误");
        }
        // 更新新密码
        adminMapper.updatePassword(id, newPassword);
    }

    @Override
    public Admin findById(Integer id) {
        return adminMapper.findById(id);
    }

    @Override
    public Admin findByUsername(String username) {
        return adminMapper.findByUsername(username);
    }
} 