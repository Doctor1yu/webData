package com.back.backdata.mapper;

import com.back.backdata.pojo.Orders;
import com.back.backdata.pojo.User;
import com.back.backdata.pojo.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebMapper {

    // 获取所有功能信息
    @Select("SELECT * FROM orders")
    List<Orders> getAllOrders();

    // 获取所有用户信息
    @Select("SELECT * FROM user")
    List<User> getAllUsers();

    // 获取所有反馈信息
    @Select("SELECT * FROM feedback")
    List<Feedback> getAllFeedbacks();
}
