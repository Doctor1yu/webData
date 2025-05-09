package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface FeedbackMapper {

    // 根据ID删除反馈
    @Delete("DELETE FROM feedback WHERE id = #{id}")
    int deleteFeedbackById(int id);

    // 根据ID更新反馈答案、答案名称和更新时间
    @Update("UPDATE feedback SET answer = #{answer}, answer_name = #{answerName}, status = #{status}, updated_at = NOW() WHERE id = #{id}")
    int updateFeedbackAnswerById(int id, String answer, String answerName, int status);
}
