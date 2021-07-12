package com.wt.entity;

import java.util.Date;

public class User {
    private int uid; // 编号
    private String name; // 真实姓名
    private String phone; // 手机号
    private int age; // 年龄
    private int sex; // 性别 0：男  1：女
    private String username; // 用户名
    private String password; // 用户密码
    private String picture; // 用户头像路径
    private int status; // 用户状态 1：启用 2：禁用
    private Date createtime; // 注册时间
    private int role; // 用户角色 1：管理员 2：一般用户 3：VIP用户

    public User() {
    }

    public User(int uid, String name, String phone, int age, int sex, String username, String password, String picture, int status, Date createtime, int role) {
        this.uid = uid;
        this.name = name;
        this.phone = phone;
        this.age = age;
        this.sex = sex;
        this.username = username;
        this.password = password;
        this.picture = picture;
        this.status = status;
        this.createtime = createtime;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", picture='" + picture + '\'' +
                ", status=" + status +
                ", createtime=" + createtime +
                ", role=" + role +
                '}';
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}