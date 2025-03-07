package com.back.backdata.mapper;

import com.back.backdata.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    //根据管理员名查询管理员信息
    @Select("select * from admin where username = #{username}")
    Admin findByUsername(String username);

    //根据管理员ID查询管理员信息
    @Select("select * from admin where id = #{id}")
    Admin findById(Integer id);

    //更新管理员密码
    @Update("update admin set password = #{password} where id = #{id}")
    void updatePassword(Integer id,String password);
}