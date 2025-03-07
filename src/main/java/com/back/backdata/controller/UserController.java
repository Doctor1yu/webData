package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.pojo.User;
import com.back.backdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(User user) {
        try {
            User registeredUser = userService.register(user);
            return Result.success(registeredUser);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    @PostMapping("/login")
    public Result login(@RequestParam String studentId, @RequestParam String password) {
        try {
            User user = userService.login(studentId, password);
            return Result.success(user);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    @PatchMapping("/changePassword")
    public Result changePassword(@RequestParam String studentId,
            @RequestParam String oldPassword,
            @RequestParam String newPassword,
            @RequestParam String confirmPassword) {
        try {
            userService.changePassword(studentId, oldPassword, newPassword, confirmPassword);
            return Result.success("密码修改成功");
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    @PutMapping("/updateProfile")
    public Result updateProfile(User user) {
        try {
            User updatedUser = userService.updateProfile(user);
            return Result.success(updatedUser);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }
}
