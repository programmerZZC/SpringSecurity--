package com.springsecurity.sevice.impl;

import com.springsecurity.domain.User;
import com.springsecurity.enums.UserStatusEnum;
import com.springsecurity.sevice.CheckLoginService;
import com.springsecurity.util.RequestAndResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Service
//@slf4j
public class CheckLoginServiceImpl implements CheckLoginService {

//    @Autowired
//    private UserService userService;

    @Override
    public boolean verfication_admin() {
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
        Cookie[] cookies = RequestAndResponseUtil.getRequest().getCookies();
        User user;

        for (Cookie cookie : cookies){
//            if (cookie.getName().equals("username")){
//                user = userService.findUserName(cookie.getValue());
//                if (user==null){
//                    log.error("[验证用户失败]找不到用户：{}",cookie.getValue());
//                    return false;
//                }
//                if(user.getUSerStatus.equals(UserStatusEnum.ADMIN.getCode())){
//                    log.info("[验证管理员身份成功]用户名：{}",cookie.getValue());
//                    return true;
//                }
//            }
        }
//        log.error("[验证用户失败]cookie不存在");
        return false;
    }
}
