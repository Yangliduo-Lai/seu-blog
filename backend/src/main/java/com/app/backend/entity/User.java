package com.app.backend.entity;

import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class User {
    public enum Role { user, blogger, admin }

    @Id
    private Integer userId;
    private String username;
    private String password;
    private String email;
    private Role role;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
