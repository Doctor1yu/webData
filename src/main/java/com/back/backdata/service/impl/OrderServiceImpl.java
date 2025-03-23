package com.back.backdata.service.impl;

import com.back.backdata.mapper.OrderMapper;
import com.back.backdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int deleteOrderById(int id) {
        return orderMapper.deleteOrderById(id);
    }
}