package com.back.backdata.mapper;

import com.back.backdata.pojo.Rotation;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RotationMapper {
    // 插入轮播图
    @Insert("INSERT INTO rotation(theme, rotation_url) " +
            "VALUES(#{theme}, #{rotationUrl})")
    void insert(Rotation rotation);

    // 根据ID删除轮播图
    @Delete("DELETE FROM rotation WHERE id = #{id}")
    void deleteById(Integer id);
}
