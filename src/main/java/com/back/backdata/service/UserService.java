package com.back.backdata.service;

import com.back.backdata.pojo.User;

public interface UserService {
    void updatePassword(int id, String newPassword);
    void updateStatus(int id, String status);
    void deleteUser(int id);
} 