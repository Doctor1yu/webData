package com.back.backdata.mapper;

import com.back.backdata.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    // 根据学号查询用户信息
    @Select("SELECT * FROM user WHERE student_id = #{studentId}")
    User findUserByStudentId(@Param("studentId") String studentId);

    // 插入新用户
    @Insert("INSERT INTO user(student_id, password, phone_number, nick_name, avatar_url) " +
            "VALUES(#{studentId}, #{password}, #{phoneNumber}, #{nickName}, #{avatarUrl})")
    void insertUser(User user);

    // 更新用户密码
    @Update("UPDATE user SET password = #{newPassword} WHERE student_id = #{studentId}")
    void updatePassword(@Param("studentId") String studentId, @Param("newPassword") String newPassword);

    // 更新用户信息
    @Update("UPDATE user SET phone_number = #{phoneNumber}, nick_name = #{nickName}, avatar_url = #{avatarUrl} " +
            "WHERE student_id = #{studentId}")
    void updateProfile(User user);
}
