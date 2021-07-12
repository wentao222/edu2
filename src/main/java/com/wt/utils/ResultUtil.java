package com.wt.utils;

/**
 * 用于存储用户登录验证信息的工具类
 */
public class ResultUtil {
    // 反馈给页面的提示信息
    private String message;

    // 反馈的数据
    private Object Obj;

    // 状态码
    private int status;

    public ResultUtil() {
    }

    public ResultUtil(String message, Object obj, int status) {
        this.message = message;
        Obj = obj;
        this.status = status;
    }

    @Override
    public String toString() {
        return "ResultUtil{" +
                "message='" + message + '\'' +
                ", Obj=" + Obj +
                ", status=" + status +
                '}';
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return Obj;
    }

    public void setObj(Object obj) {
        Obj = obj;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
