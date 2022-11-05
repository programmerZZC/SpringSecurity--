package com.springsecurity.aspect;

import com.springsecurity.enums.ResultEnum;
import com.springsecurity.exception.ReportException;
import com.springsecurity.sevice.CheckLoginService;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VerificationAspect {

    @Autowired
    private CheckLoginService checkLoginService;

    @Pointcut("execution(* com.springsecurity.controller.HelloController.*admin(..))")
    public void checkAdmin(){

    }

    @Before("checkAdmin()")
    public void verification_admin(){
        // 如果没有登陆，这里要抛出异常
        if(!checkLoginService.verfication_admin()){
            throw new ReportException(ResultEnum.LOGIN_ERROR);
        }
    }
}
