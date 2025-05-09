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

    // 根据学号更新用户角色
    @Update("UPDATE user SET role = #{role} WHERE student_id = #{studentId}")
    void updateUserRole(@Param("studentId") String studentId, @Param("role") int role);

    // 根据学号更新用户申请状态
    @Update("UPDATE user SET application_status = #{status} WHERE student_id = #{studentId}")
    void updateUserApplicationStatus(@Param("studentId") String studentId, @Param("status") String status);

    // 更新用户收款码
    @Update("UPDATE user SET collect_url = #{collectUrl} WHERE student_id = #{studentId}")
    void updateUserCollectUrl(String studentId, String collectUrl);
} 