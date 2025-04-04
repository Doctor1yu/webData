package com.back.backdata.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface HomeMapper {
    @Select("SELECT COUNT(*) FROM orders")
    Integer getOrderCount();

    @Select("SELECT COUNT(*) FROM user")
    Integer getUserCount();

    @Select("SELECT COUNT(*) FROM applications")
    Integer getApplyCount();

    @Select("SELECT COUNT(*) FROM feedback")
    Integer getFeedbackCount();

    @Select("SELECT COUNT(*) FROM rotation")
    Integer getCarouselCount();

    @Select("SELECT COUNT(*) FROM orders WHERE status = 1 AND created_at >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)")
    Integer getPendingOrderCount();

    @Select("SELECT COUNT(*) FROM orders WHERE status = 2 AND created_at >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)")
    Integer getProcessingOrderCount();

    @Select("SELECT COUNT(*) FROM orders WHERE status = 3 AND created_at >= DATE_SUB(CURDATE(), INTERVAL 30 DAY)")
    Integer getCompletedOrderCount();

    @Select("SELECT COUNT(*) FROM feedback WHERE subject = '快递员问题'")
    Integer getCourierIssueCount();

    @Select("SELECT COUNT(*) FROM feedback WHERE subject = '平台问题'")
    Integer getPlatformIssueCount();

    @Select("SELECT COUNT(*) FROM feedback WHERE subject = '送货时间安排'")
    Integer getDeliveryTimeCount();

    @Select("SELECT COUNT(*) FROM feedback WHERE subject = '金额问题'")
    Integer getPaymentIssueCount();

    @Select("SELECT COUNT(*) FROM feedback WHERE subject = '其他问题'")
    Integer getOtherIssueCount();
}