package com.wt.dao.impl;

import com.wt.dao.UserDao;
import com.wt.entity.User;
import com.wt.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    // 获取QueryRunner对象
    QueryRunner qr = JdbcUtil.getQueryRunner();

    // 以账号和密码查询对象
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        User u = null;

        String sql = "select * from user where username = ? and password = ?";

        try {
            u = qr.query(sql, new BeanHandler<>(User.class), username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return u;
    }
}
