package com.zyq.quick_monitor.entity;

import com.zyq.quick_monitor.common.plugin.MongoModel;

/**
 * Created by Administrator on 2016/6/24.
 */
public class Mstsc extends MongoModel<Mstsc> {
    public String s = "123";
    private String address;//地址
    private String username;//用户名
    private String pass;//密码

    public String getAddress() {
        return address;
    }

    public Mstsc setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public Mstsc setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPass() {
        return pass;
    }

    public Mstsc setPass(String pass) {
        this.pass = pass;
        return this;
    }

}
