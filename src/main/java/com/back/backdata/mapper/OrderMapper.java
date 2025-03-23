package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @Delete("DELETE FROM orders WHERE id = #{id}")
    int deleteOrderById(int id);
}


