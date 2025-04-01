package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.pojo.Rotation;
import com.back.backdata.service.RotationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rotation")
public class RotationController {

    @Autowired
    private RotationService rotationService;

    @PostMapping("/add")
    public Result addRotation(@RequestParam String theme, @RequestParam String rotationUrl) {
        Rotation rotation = new Rotation();
        rotation.setTheme(theme);
        rotation.setRotationUrl(rotationUrl);
        rotationService.addRotation(rotation);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteRotationById(@RequestParam Integer id) {
        rotationService.deleteRotationById(id);
        return Result.success();
    }
}
