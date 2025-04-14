package com.back.backdata.service;

public interface FeedbackService {

    int deleteFeedbackById(int id);
    int updateFeedbackAnswerById(int id, String answer, String answerName);
}
