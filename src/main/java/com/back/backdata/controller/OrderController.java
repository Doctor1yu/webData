package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @DeleteMapping("/delete")
    public Result deleteOrderById(@RequestParam int id) {
        int result = orderService.deleteOrderById(id);
        if (result > 0) {
            return Result.success();
        } else {
            return Result.error("删除失败，订单可能不存在");
        }
    }
}
