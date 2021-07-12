package com.wt.dao;

import com.wt.entity.User;

public interface UserDao {
    // 以账号和密码查询对象
    public abstract User getUserByUsernameAndPassword(String username, String password);
}
