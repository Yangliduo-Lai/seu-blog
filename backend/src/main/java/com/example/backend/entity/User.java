package com.example.backend.entity;

import java.time.LocalDateTime;

public class User {
    private Integer userid;
    private String username;
    private String password;
    private String email;
    private byte[] avatar;
    private LocalDateTime birthday;
    private String phone;

    public Integer getUserid() {
        return userid;
    }
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }
    public User setUsername(String username) {
        this.username = username;
        return null;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }
    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
