package com.wt.servlet;

import com.wt.entity.User;
import com.wt.service.impl.UserServiceImpl;
import com.wt.utils.JsonUtil;
import com.wt.utils.ResultUtil;
import com.wt.utils.VerifyCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {

    UserServiceImpl us = new UserServiceImpl();

    // 生成随机验证码并返回页面
    private void getImageCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 生成验证码字符串
        String verCode = VerifyCodeUtils.generateVerifyCode(4);

        // 把验证码存入session
        HttpSession session = req.getSession();
        session.removeAttribute("verCode"); // 存入之前删除之前的验证码
        session.setAttribute("verCode", verCode);

        // 把生成的验证码生成图片并返回给页面
        VerifyCodeUtils.outputImage(100, 30, resp.getOutputStream(), verCode);
    }

    // 登录验证，验证后反馈给页面验证结果
    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取页面的登录信息
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");

        // 获取验证结果的json对象
        String res = us.validateLogin(req.getSession(), code, username, password);
        System.out.println("登录信息JSON：" + res);
        // 发送给页面
        PrintWriter out = resp.getWriter();
        out.print(res);
        out.close();
    }

    // 获取用户信息
    private void getUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从session对象中获取以登录的User对象
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        // 反馈给页面
        PrintWriter out = resp.getWriter();
        out.print(JsonUtil.toJson(user));
        out.close();
    }


    // 退出登录
    private void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 删除用户信息
        HttpSession session = req.getSession();
        session.invalidate();

        // 返回退出的提示信息
        PrintWriter out = resp.getWriter();
        out.print(JsonUtil.toJson(new ResultUtil("正在退出登录", null, 1)));
        out.close();
    }

}
