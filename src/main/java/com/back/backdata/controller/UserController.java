package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.pojo.User;
import com.back.backdata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PatchMapping("/{id}/password")
    public Result<Void> updatePassword(@PathVariable int id, @RequestParam String newPassword) {
        userService.updatePassword(id, newPassword);
        return Result.success();
    }

    @PatchMapping("/{id}/status")
    public Result<Void> updateStatus(@PathVariable int id, @RequestParam String status) {
        userService.updateStatus(id, status);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return Result.success();
    }
}
