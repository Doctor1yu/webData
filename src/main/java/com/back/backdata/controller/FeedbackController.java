package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @DeleteMapping("/delete")
    public Result deleteFeedbackById(@RequestParam int id) {
        int result = feedbackService.deleteFeedbackById(id);
        if (result > 0) {
            return Result.success();
        } else {
            return Result.error("删除失败，反馈可能不存在");
        }
    }

    @PatchMapping("/updateAnswer")
    public Result updateFeedbackAnswerById(@RequestParam int id, @RequestParam String answer, @RequestParam String answerName) {
        int result = feedbackService.updateFeedbackAnswerById(id, answer, answerName);
        if (result > 0) {
            return Result.success();
        } else {
            return Result.error("更新失败，反馈可能不存在");
        }
    }
}
