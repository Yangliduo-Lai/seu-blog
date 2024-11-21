package com.example.backend.entity;

import java.io.Serializable;

public class AuthenRequest implements Serializable {
    private Integer userid;
    private String username;
    private String password;

    public Integer getUserid() {
        return userid;
    }

    public AuthenRequest setUserid(Integer userid) {
        this.userid = userid;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public AuthenRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthenRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
