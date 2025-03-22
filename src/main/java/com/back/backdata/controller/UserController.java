package com.back.backdata.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

//    @GetMapping("/userInfo")
//    public Result<User> getUserInfo(@RequestHeader(name = "Authorization") String token) {
//        // 根据用户名查询用户
//        Map<String,Object> map = JwtUtil.parseToken(token);
//        String studentId = map.get("studentId");
//
//        User user = userService.findByStudentId(studentId);
//        return Result.success(user);
//    }
}
