package com.back.backdata.controller;

import com.back.backdata.pojo.Result;
import com.back.backdata.pojo.Rotation;
import com.back.backdata.service.RotationService;
import com.back.backdata.utils.ImageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/rotation")
public class RotationController {

    @Autowired
    private RotationService rotationService;

    @Autowired
    private ImageUtil imageUtil;

    @DeleteMapping("/delete")
    public Result deleteRotationById(@RequestParam Integer id) {
        rotationService.deleteRotationById(id);
        return Result.success();
    }

    @PostMapping("/upload")
    public Result uploadRotationImage(@RequestParam String theme, @RequestPart("file") MultipartFile file) {
        try {
            // 上传图片到七牛云并获取URL
            String rotationUrl = imageUtil.uploadImage(file);
            
            if (rotationUrl == null) {
                return Result.error("图片上传失败");
            }
            
            Rotation rotation = new Rotation();
            rotation.setTheme(theme);
            rotation.setRotationUrl(rotationUrl);
            
            // 保存到数据库
            rotationService.addRotation(rotation);
            
            return Result.success(rotationUrl);
        } catch (Exception e) {
            return Result.error("轮播图上传失败: " + e.getMessage());
        }
    }
}
