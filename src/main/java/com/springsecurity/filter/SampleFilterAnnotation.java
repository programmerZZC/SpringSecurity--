package com.springsecurity.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@Order(2)
@WebFilter(filterName = "SampleFilterAnnotation",urlPatterns = {"/study/interfaces/v1/user/*"})
public class SampleFilterAnnotation implements Filter{

    public void init(FilterConfig filterConfig) throws ServletException{
        System.out.println("SampleFilterAnnotation---初始化Filter");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("SampleFilterAnnotation---进入Target Resource之前做的事");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("SampleFilterAnnotation---处理返回的Response");
    }

    public void destroy(){
        System.out.println("SampleFilterAnnotation---销毁Filter");
    }
}
