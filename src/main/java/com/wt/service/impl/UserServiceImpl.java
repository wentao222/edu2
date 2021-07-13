package com.wt.service.impl;

import com.wt.dao.impl.UserDaoImpl;
import com.wt.entity.User;
import com.wt.service.UserService;
import com.wt.utils.JsonUtil;
import com.wt.utils.PageUtil;
import com.wt.utils.ResultUtil;

import javax.servlet.http.HttpSession;
import javax.xml.transform.Result;
import java.util.List;

public class UserServiceImpl implements UserService {

    UserDaoImpl ud = new UserDaoImpl();

    // 验证登录信息
    @Override
    public String validateLogin(HttpSession session, String code, String username, String password) {
        // 初始化一个登录验证结果
        ResultUtil res = null;

        // 获取生成验证码时，存入session中的验证码
        String verCode = (String)session.getAttribute("verCode");

        // 把生成的验证码和登录时输入的验证码比较
        if(code.equalsIgnoreCase(verCode)) { // 若验证码正确，再验证账号密码

            // 获取以账号密码查询到的用户信息,
            User u = ud.getUserByUsernameAndPassword(username, password);
            if(u != null) {// 不为空则账号密码正确,再验证用户状态
                if(u.getStatus() == 1) { // 用户状态status为1,再验证用户的角色
                    if(u.getRole() == 1) { // 1为管理员可以登录
                        // 登录成功把User信息放在session中，用于登录后展示用户信息
                        session.setAttribute("user", u);
                        res = new ResultUtil("登录成功", null, 1);
                    }else {
                        res = new ResultUtil("对不起，您不是管理员，无法登录", null, 1);
                    }
                }else { // status不为1则是禁用状态
                    res = new ResultUtil("用户被冻结", null, 1);
                }
            }else { // 账号密码错误
                res = new ResultUtil("账号或密码错误", null, 1);
            }
        }else { // 验证码错误
            res = new ResultUtil("验证码错误", null, 1);
        }

        // 把登录的验证信息封装成ResultUtil对象并转为json对象
        return JsonUtil.toJson(res);
    }

    // 获取分页信息
    @Override
    public String getPage(String currentPage, int pageSize, User user) {
        // 获取数据总条数
        int countRows = ud.getCountRows(user.getUsername());

        // 分页查询起始位置
        if(currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        int start = (Integer.parseInt(currentPage) - 1) * pageSize;
        // 分页查询
        List<User> list = ud.getUserList(user.getUsername(), start, pageSize);

        // 获取PageUtil对象
        PageUtil page = new PageUtil(currentPage, pageSize, countRows, user, list);

        return JsonUtil.toJson(page);
    }

    // 获取修改后的反馈信息
    @Override
    public String updateUser(User u) {
        ResultUtil ru = null;
        // 获取修改后的受影响行数
        int rows = ud.updateUser(u);

        if(rows > 0) {
            ru = new ResultUtil("修改成功", null, 1);
        }else {
            ru = new ResultUtil("修改失败", null, 2);
        }
        return JsonUtil.toJson(ru);
    }

    @Override
    public String addUser(User user) {
        ResultUtil ru = null;

        // 获取添加后的受影响行数
        int rows = ud.addUser(user);

        if(rows > 0){
            ru = new ResultUtil("添加成功", null, 1);
        }else {
            ru = new ResultUtil("添加失败", null, 2);
        }

        return JsonUtil.toJson(ru);
    }

    // 删除
    @Override
    public String delAll(String uids) {
        ResultUtil ru = null;

        // 获取添加后的受影响行数
        int rows = ud.delAll(uids);

        if(rows > 0){
            ru = new ResultUtil("删除成功", null, 1);
        }else {
            ru = new ResultUtil("删除失败", null, 2);
        }

        return JsonUtil.toJson(ru);
    }


}
