package com.java.entity;

/**
 * 管理员实体
 *
 * @author clay
 * @site www.java1234.com
 * @create 2020-02-16 12:37
 */
public class Admin {

    private int id;
    private String userName;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
