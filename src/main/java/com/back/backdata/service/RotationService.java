package com.back.backdata.service;

import com.back.backdata.pojo.Rotation;

public interface RotationService {
    void addRotation(Rotation rotation);
    void deleteRotationById(Integer id);
}
