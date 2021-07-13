package com.wt.service;

import com.wt.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    // 登录验证
    public abstract String validateLogin(HttpSession session, String code, String username, String password);

    // 获取分页信息
    String getPage(String currentPage, int pageSize, User user);

    // 获取修改后的反馈信息
    public String updateUser(User u);

    // 获添加后的反馈信息
    String addUser(User user);

    // 删除
    String delAll(String uids);
}
