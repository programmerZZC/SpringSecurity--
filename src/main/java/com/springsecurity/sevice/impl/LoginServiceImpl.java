package com.springsecurity.sevice.impl;

import com.springsecurity.domain.LoginUser;
import com.springsecurity.domain.ResponseResult;
import com.springsecurity.domain.User;
import com.springsecurity.sevice.LoginService;
import com.springsecurity.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(User user) {
        // AuthenticationManager authenticate进行用户认证
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        // 如果认证没通过，给出对应的提示
        if (Objects.isNull(authenticate)){
            throw new RuntimeException("登陆失败");
        }
        // 如果认证通过了，使用userid生成一个jwt jwt存入ResponseResult返回
        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        String userid = principal.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userid);
        // 把完整的用户信息存入redis userid最为key
        Map<String,String> map = new HashMap<>();
        map.put("token",jwt);
        return new ResponseResult(200,"登陆成功",map);
    }
}
