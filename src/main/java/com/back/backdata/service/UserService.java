package com.back.backdata.service;

import com.back.backdata.pojo.User;

public interface UserService {
    User findByStudentId(String studentId);
} 