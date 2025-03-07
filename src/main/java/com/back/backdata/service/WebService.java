package com.back.backdata.service;

import com.back.backdata.pojo.Function;
import com.back.backdata.pojo.User;
import java.util.List;

public interface WebService {
    List<Function> getAllFunctions();
    List<User> getAllUsers();
}
