package com.springsecurity.sevice.impl;

import com.springsecurity.enums.ResultEnum;
import com.springsecurity.exception.ReportException;
import com.springsecurity.sevice.LoginAndLogoutService;
import com.springsecurity.util.RequestAndResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.Cookie;

public class LoginAndLogoutServiceImpl implements LoginAndLogoutService {

//    @Autowired
//    private UserService userService;

    @Override
    public boolean login(String username, String password) {
//        User user = userService.findByUserName(username);
//        if (user==null){
//            log.error("【登陆失败】用户不存在，用户名:{}",username);
//            throw new ReportException(ResultEnum.USER_NULL);
//        }
//        // 验证密码
//        if (user.getUserPassword().equals(password)){
//            // 设置cookie，注意要des加密
//            Cookie cookie = new Cookie("username",username);
//            cookie.setMaxAge(60*60*24*7);
//            RequestAndResponseUtil.getReponse().addCookie(cookie);
//            log.info("【登陆成功】用户名:{}",username);
//            return true;
//        }else {
//            log.error("【登陆失败】用户名:{},密码:{}",username,password);
//            return false;
//        }
        return true;
    }

    @Override
    public boolean logout(String username) {
        Cookie[] cookies = RequestAndResponseUtil.getRequest().getCookies();
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("username")){
                cookie.setMaxAge(0);
                RequestAndResponseUtil.getReponse().addCookie(cookie);
//                log.info("【注销成功】用户名:{}",username);
                return true;
            }
        }
//        log.error("【注销失败】没有找到cookie,用户名:{}",username);
        return false;
    }
}
