package com.back.backdata.controller;

import com.back.backdata.pojo.Admin;
import com.back.backdata.pojo.Result;
import com.back.backdata.service.AdminService;
import com.back.backdata.utils.JwtUtil;
import com.back.backdata.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //管理员登陆
    @PostMapping("/login")
    public Result login(Admin admin) {
        try {
            // 使用loginAdmin方法替代login方法
            Admin loginAdmin = adminService.loginAdmin(admin.getUsername(), admin.getPassword());

            // 生成token
            Map<String, Object> claims = new HashMap<>();
            claims.put("id", loginAdmin.getId());
            claims.put("username", loginAdmin.getUsername());
            String token = JwtUtil.genToken(claims);

            // 存储到redis
            stringRedisTemplate.opsForValue().set(token, token, 1, TimeUnit.HOURS);

            return Result.success(token);
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }

    //更改管理员密码
    @PatchMapping("/updatePwd")
    public Result updatePassword(@RequestBody Map<String, String> params) {
        // 获取请求参数
        String oldPwd = params.get("old_pwd");
        String newPwd = params.get("new_pwd");
        String rePwd = params.get("re_pwd");
        
        if (oldPwd == null || newPwd == null || rePwd == null) {
            return Result.error("缺少必要参数");
        }
        
        if (!newPwd.equals(rePwd)) {
            return Result.error("两次输入的新密码不一致");
        }

        try {
            // 从ThreadLocal获取用户ID
            Map<String, Object> claims = ThreadLocalUtil.get();
            Integer id = Integer.valueOf(claims.get("id").toString());

            // 修改密码
            adminService.updateAdminPassword(id, oldPwd, newPwd);
            return Result.success();
        } catch (RuntimeException e) {
            return Result.error(e.getMessage());
        }
    }
}