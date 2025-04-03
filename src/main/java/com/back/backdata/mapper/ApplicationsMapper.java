package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Select;
import com.back.backdata.pojo.Applications;
@Mapper
public interface ApplicationsMapper {
    @Update("UPDATE applications SET status = #{status}, reviewer_name = #{reviewerName}, remark = #{remark}, reviewed_at = #{reviewedAt} WHERE id = #{id}")
    void updateApplication(Applications application);

    @Select("SELECT student_id FROM applications WHERE id = #{id}")
    String getStudentIdById(int id);
}
