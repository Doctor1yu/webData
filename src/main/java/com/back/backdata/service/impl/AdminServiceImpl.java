package com.back.backdata.service.impl;

import com.back.backdata.pojo.Admin;
import com.back.backdata.mapper.AdminMapper;
import com.back.backdata.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

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

    // 更新管理员密码
    @Override
    public void updateAdminPassword(Integer id, String oldPassword, String newPassword) {
        // 查询用户信息
        Admin admin = adminMapper.findById(id);
        if (admin == null) {
            throw new RuntimeException("用户不存在");
        }
        
        // 验证旧密码
        if (!admin.getPassword().equals(oldPassword)) {
            throw new RuntimeException("原密码错误");
        }
        
        // 检查新密码是否与旧密码相同
        if (oldPassword.equals(newPassword)) {
            throw new RuntimeException("新密码不能与旧密码相同");
        }
        
        // 更新新密码
        adminMapper.updatePassword(id, newPassword);
    }

    // 根据ID查询管理员信息
    @Override
    public Admin findById(Integer id) {
        return adminMapper.findById(id);
    }

    // 根据用户名查询管理员信息
    @Override
    public Admin findByUsername(String username) {
        return adminMapper.findByUsername(username);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminMapper.findAll();
    }

    @Override
    public void addAdmin(String username, String password) {
        // 检查用户名是否已存在
        Admin existingAdmin = adminMapper.findByUsername(username);
        if (existingAdmin != null) {
            throw new RuntimeException("用户名已存在");
        }
        
        // 创建新管理员
        Admin newAdmin = new Admin();
        newAdmin.setUsername(username);
        newAdmin.setPassword(password);
        newAdmin.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        newAdmin.setUpdateAt(new Timestamp(System.currentTimeMillis()));
        
        adminMapper.insertAdmin(newAdmin);
    }

    @Override
    public void deleteAdminById(Integer id) {
        // 检查管理员是否存在
        Admin admin = adminMapper.findById(id);
        if (admin == null) {
            throw new RuntimeException("管理员不存在");
        }
        
        // 执行删除操作
        adminMapper.deleteAdminById(id);
    }
} 