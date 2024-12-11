package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    public enum Role { user, blogger, admin }

    private Integer user_id;
    private String user_name;
    private String password;
    private String email;
    private Role role;
    private LocalDateTime created_time;
    private LocalDateTime updated_time;
    private String avatar;
    private String nickname;
    private String signature;
}
