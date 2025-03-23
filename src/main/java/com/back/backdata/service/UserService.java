package com.back.backdata.service;

import com.back.backdata.pojo.User;

public interface UserService {
    void resetPassword(String studentId);
    void updateStatus(int id, String status);
    void deleteUser(int id);
} 