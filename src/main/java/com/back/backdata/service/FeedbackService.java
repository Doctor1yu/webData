package com.back.backdata.service;

public interface FeedbackService {

    int deleteFeedbackById(int id);
    int updateFeedbackStatusById(int id, int status);
}
