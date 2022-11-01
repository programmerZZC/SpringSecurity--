package com.springsecurity.sevice;

import com.springsecurity.domain.ResponseResult;
import com.springsecurity.domain.User;

public interface LoginService {
    ResponseResult login(User user);
}
