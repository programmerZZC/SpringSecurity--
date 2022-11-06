package com.springsecurity.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    SampleIntereptor sampleIntereptor;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(sampleIntereptor).addPathPatterns("/**")
                .excludePathPatterns("/**/LoginController/**/","/**/error")
                .excludePathPatterns("/error");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

}
