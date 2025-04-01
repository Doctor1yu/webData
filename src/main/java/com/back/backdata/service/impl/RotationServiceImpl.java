package com.back.backdata.service.impl;

import com.back.backdata.mapper.RotationMapper;
import com.back.backdata.pojo.Rotation;
import com.back.backdata.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RotationServiceImpl implements RotationService {
    
    @Autowired
    private RotationMapper rotationMapper;

    @Override
    public void addRotation(Rotation rotation) {
        rotationMapper.insert(rotation);
    }

    @Override
    public void deleteRotationById(Integer id) {
        rotationMapper.deleteById(id);
    }
}
