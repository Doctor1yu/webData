package com.back.backdata.controller;

import com.back.backdata.pojo.Function;
import com.back.backdata.pojo.User;
import com.back.backdata.service.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class WebController {

    @Autowired
    private WebService webService;

    @GetMapping("/functions")
    public List<Function> getAllFunctions() {
        return webService.getAllFunctions();
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return webService.getAllUsers();
    }
}
