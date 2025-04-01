package com.back.backdata.mapper;

import com.back.backdata.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {

    // 根据管理员名查询管理员信息
    @Select("select * from admin where username = #{username}")
    Admin findByUsername(String username);

    // 根据管理员ID查询管理员信息
    @Select("select * from admin where id = #{id}")
    Admin findById(Integer id);

    // 更新管理员密码
    @Update("update admin set password = #{password}, update_at = now() where id = #{id}")
    void updatePassword(Integer id, String password);

    // 获取所有管理员信息
    @Select("select * from admin")
    List<Admin> findAll();

    // 插入新管理员
    @Insert("insert into admin (username, password, created_at, update_at) " +
            "values (#{username}, #{password}, #{createdAt}, #{updateAt})")
    void insertAdmin(Admin admin);

    // 根据ID删除管理员
    @Delete("delete from admin where id = #{id}")
    void deleteAdminById(Integer id);
}