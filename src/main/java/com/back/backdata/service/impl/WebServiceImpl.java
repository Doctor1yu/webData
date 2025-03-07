package com.back.backdata.service.impl;

import com.back.backdata.mapper.WebMapper;
import com.back.backdata.pojo.Function;
import com.back.backdata.pojo.User;
import com.back.backdata.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WebServiceImpl implements WebService {

    @Autowired
    private WebMapper webMapper;

    @Override
    public List<Function> getAllFunctions() {
        return webMapper.getAllFunctions();
    }

    @Override
    public List<User> getAllUsers() {
        return webMapper.getAllUsers();
    }
}
