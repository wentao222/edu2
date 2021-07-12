package com.wt.service;

import javax.servlet.http.HttpSession;

public interface UserService {
    public abstract String validateLogin(HttpSession session, String code, String username, String password);
}
