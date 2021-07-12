package com.wt.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf8");
        resp.setContentType("text/html;charset=utf8");

        String flag = req.getParameter("flag");
        System.out.println("执行的方法：" + flag);

        Class<? extends BaseServlet> aClass = this.getClass();
        Method m = null;
        try {
            m = aClass.getDeclaredMethod(flag, HttpServletRequest.class, HttpServletResponse.class);
            m.setAccessible(true);
            m.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
