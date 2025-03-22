package com.back.backdata.mapper;

import com.back.backdata.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //根据学号查询用户
    @Select("SELECT * FROM user WHERE student_id = #{studentId}")
    User findByStudentId(String studentId);
} 