package com.wt.dao.impl;

import com.wt.dao.UserDao;
import com.wt.entity.User;
import com.wt.utils.JdbcUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

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

    //指定用户名模糊查询数据条数
    @Override
    public int getCountRows(String username) {
        int countRows = 0;
        String sql = "select count(*) from user where username like '%" + username + "%'";
        try {
            countRows = (int)(long)qr.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return countRows;
    }

    //指定用户名模糊分页查询用户集合
    @Override
    public List<User> getUserList(String username, int start, int pageSize) {
        List<User> list = null;
        String sql = "select * from user where username like '%" + username + "%' limit ?,?";
        try {
            list = qr.query(sql, new BeanListHandler<>(User.class), start, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // 修改User
    @Override
    public int updateUser(User u) {
        int rows = 0;
        String sql = "update user set name=?, phone=?, age=?, sex=?, username=?, password=?, status=?, role=? where uid=?";
        try {
            rows = qr.update(sql, u.getName(), u.getPhone(), u.getAge(), u.getSex(), u.getUsername(), u.getPassword(), u.getStatus(), u.getRole(), u.getUid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int addUser(User u) {
        int rows = 0;
        String sql = "insert into user values(null, ?,?,?,?,?,?,?,?,?,?)";
        try {
            rows = qr.update(sql, u.getName(), u.getPhone(),u.getAge(),u.getSex(), u.getUsername(), u.getPassword(),
                    u.getStatus(), u.getCreatetime(), u.getRole(), u.getPicture());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    // 删除
    @Override
    public int delAll(String uids) {
        int rows = 0;
        String sql = "delete from user where uid in (" + uids + ")";
        try {
            rows = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }


}
