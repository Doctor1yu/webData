package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface FeedbackMapper {

    // 根据ID删除反馈
    @Delete("DELETE FROM feedback WHERE id = #{id}")
    int deleteFeedbackById(int id);

    // 根据ID更新反馈状态
    @Update("UPDATE feedback SET status = #{status}, updated_at = NOW() WHERE id = #{id}")
    int updateFeedbackStatusById(int id, int status);
}
