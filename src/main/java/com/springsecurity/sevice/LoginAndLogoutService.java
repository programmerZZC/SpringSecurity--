package com.springsecurity.sevice;

public interface LoginAndLogoutService {

    public boolean login(String username,String password);

    public boolean logout(String username);

}
