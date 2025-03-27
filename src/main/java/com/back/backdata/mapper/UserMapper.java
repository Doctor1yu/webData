package com.back.backdata.mapper;

import com.back.backdata.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    // 根据学号查询用户信息
    @Select("SELECT * FROM user WHERE student_id = #{studentId}")
    User getUserByStudentId(String studentId);

    // 根据学号更新密码
    @Update("UPDATE user SET password = #{newPassword} WHERE student_id = #{studentId}")
    void updatePasswordByStudentId(@Param("studentId") String studentId, @Param("newPassword") String newPassword);

    // 根据学号更新用户状态
    @Update("UPDATE user SET status = #{status} WHERE student_id = #{studentId}")
    void updateStatus(@Param("studentId") String studentId, @Param("status") String status);

    // 根据ID删除用户
    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(int id);
} 