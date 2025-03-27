package com.back.backdata.config;

import com.back.backdata.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(@NonNull InterceptorRegistry login) {
        //登录接口不拦截
        login.addInterceptor(loginInterceptor).excludePathPatterns("/admin/login");
    }
}
