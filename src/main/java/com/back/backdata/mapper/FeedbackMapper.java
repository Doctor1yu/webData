package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface FeedbackMapper {


    @Delete("DELETE FROM feedback WHERE id = #{id}")
    int deleteFeedbackById(int id);

    @Update("UPDATE feedback SET status = #{status}, updated_at = NOW() WHERE id = #{id}")
    int updateFeedbackStatusById(int id, int status);
}
