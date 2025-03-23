package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PatchMapping("/password")
    public Result resetPassword(@RequestParam String studentId) {
        userService.resetPassword(studentId);
        return Result.success();
    }

    @PatchMapping("status")
    public Result updateStatus(@RequestParam int id, @RequestParam String status) {
        userService.updateStatus(id, status);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteUser(@RequestParam int id) {
        userService.deleteUser(id);
        return Result.success();
    }
}
