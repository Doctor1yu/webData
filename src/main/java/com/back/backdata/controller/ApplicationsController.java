package com.back.backdata.controller;

import com.back.backdata.service.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Timestamp;
import com.back.backdata.pojo.Result;

@RestController
@RequestMapping("/applications")
public class ApplicationsController {

    @Autowired
    private ApplicationsService applicationsService;

    @PatchMapping("/status")
    public Result updateApplicationStatus(
            @RequestParam String studentId,
            @RequestParam String status,
            @RequestParam String remark,
            @RequestParam String reviewerName) {
        
        Timestamp reviewedAt = new Timestamp(System.currentTimeMillis());
        applicationsService.updateApplicationStatus(studentId, status, remark, reviewerName, reviewedAt);
        return Result.success();
    }
}
