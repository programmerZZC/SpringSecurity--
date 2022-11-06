package com.springsecurity.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class SampleIntereptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response){
        System.out.println("已进入拦截器");
        return true;
    }

    public void postHandle(HttpServletRequest request,HttpServletResponse response){
        System.out.println("控制器执行完毕");
    }

    public void afterCompletion(HttpServletRequest request,HttpServletResponse response){
        System.out.println("得到的返回结果："+response);
        System.out.println("请求完毕");
    }
}
