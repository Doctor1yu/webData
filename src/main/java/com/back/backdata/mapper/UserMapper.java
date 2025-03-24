package com.back.backdata.mapper;

import com.back.backdata.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE student_id = #{studentId}")
    User getUserByStudentId(String studentId);

    @Update("UPDATE user SET password = #{newPassword} WHERE student_id = #{studentId}")
    void updatePasswordByStudentId(@Param("studentId") String studentId, @Param("newPassword") String newPassword);

    @Update("UPDATE user SET status = #{status} WHERE student_id = #{studentId}")
    void updateStatus(@Param("studentId") String studentId, @Param("status") String status);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(int id);
} 