package com.app.backend.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    public enum Role { user, blogger, admin }

    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Role role;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
