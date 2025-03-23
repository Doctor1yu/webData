package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface FeedbackMapper {
    @Update("UPDATE feedback SET status = #{status} WHERE id = #{id}")
    int updateFeedbackStatus(int id, int status);

    @Delete("DELETE FROM feedback WHERE id = #{id}")
    int deleteFeedbackById(int id);
}
