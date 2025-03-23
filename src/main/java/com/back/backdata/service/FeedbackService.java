package com.back.backdata.service;

public interface FeedbackService {
    int updateFeedbackStatus(int id, int status);
    int deleteFeedbackById(int id);
}
