package com.back.backdata.mapper;

import com.back.backdata.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Update("UPDATE user SET password = #{newPassword} WHERE id = #{id}")
    void updatePassword(@Param("id") int id, @Param("newPassword") String newPassword);

    @Update("UPDATE user SET status = #{status} WHERE id = #{id}")
    void updateStatus(@Param("id") int id, @Param("status") String status);

    @Delete("DELETE FROM user WHERE id = #{id}")
    void deleteUser(int id);
} 