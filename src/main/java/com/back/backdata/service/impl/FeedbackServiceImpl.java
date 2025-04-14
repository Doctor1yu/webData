package com.back.backdata.service.impl;

import com.back.backdata.mapper.FeedbackMapper;
import com.back.backdata.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public int deleteFeedbackById(int id) {
        return feedbackMapper.deleteFeedbackById(id);
    }

    @Override
    public int updateFeedbackAnswerById(int id, String answer, String answerName) {
        return feedbackMapper.updateFeedbackAnswerById(id, answer, answerName, 2);
    }
}
