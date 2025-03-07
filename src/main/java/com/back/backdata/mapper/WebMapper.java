package com.back.backdata.mapper;

import com.back.backdata.pojo.Function;
import com.back.backdata.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebMapper {

    @Select("SELECT " +
            "id, " +
            "fun, " +
            "pickup_point AS pickupPoint, " +
            "receive_point AS receivePoint, " +
            "location, " +
            "description, " +
            "phone_number AS phoneNumber, " +
            "amount, " +
            "remark, " +
            "publisher_id AS publisherId, " +
            "publisher_nickname AS publisherNickname, " +
            "acceptor_id AS acceptorId, " +
            "created_at AS createdAt, " +
            "updated_at AS updatedAt " +
            "FROM function")
    List<Function> getAllFunctions();

    @Select("SELECT " +
            "student_id AS studentId, " +
            "phone_number AS phoneNumber, " +
            "nick_name AS nickName, " +
            "avatar_url AS avatarUrl, " +
            "created_at AS createdAt, " +
            "updated_at AS updatedAt " +
            "FROM user")
    List<User> getAllUsers();
}
