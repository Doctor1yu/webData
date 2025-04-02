package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import com.back.backdata.pojo.Applications;
@Mapper
public interface ApplicationsMapper {
    @Update("UPDATE applications SET status = #{status}, reviewer_name = #{reviewerName}, remark = #{remark}, reviewed_at = #{reviewedAt} WHERE student_id = #{studentId}")
    void updateApplication(Applications application);
}
