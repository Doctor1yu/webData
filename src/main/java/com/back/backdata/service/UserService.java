package com.back.backdata.service;

public interface UserService {
    void resetPassword(String studentId);
    void updateStatus(String studentId, String status);
    void deleteUser(int id);
} 