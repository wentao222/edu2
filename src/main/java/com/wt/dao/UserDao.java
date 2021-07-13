package com.wt.dao;

import com.wt.entity.User;

import java.util.List;

public interface UserDao {
    // 以账号和密码查询对象
    public abstract User getUserByUsernameAndPassword(String username, String password);

    //指定用户名模糊查询数据条数
    int getCountRows(String username);

    //指定用户名模糊分页查询用户集合
    List<User> getUserList(String username, int start, int pageSize);

    // 修改用户
    public int updateUser(User u);

    // 添加受影响行数
    int addUser(User user);

    // 删除
    int delAll(String uids);
}
