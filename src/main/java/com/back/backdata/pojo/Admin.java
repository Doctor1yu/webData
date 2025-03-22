package com.back.backdata.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Admin {
    private int id; // 管理员ID
    private String username; // 用户名
    private String password; // 密码
    private Timestamp createdAt; // 创建时间
}