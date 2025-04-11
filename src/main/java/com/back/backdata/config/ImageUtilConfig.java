package com.back.backdata.config;

import com.back.backdata.utils.ImageUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ImageUtilConfig {
    
    @Bean
    public ImageUtil imageUtil() {
        return new ImageUtil();
    }
} 