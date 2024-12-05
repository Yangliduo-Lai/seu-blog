package com.app.backend.entity;

import lombok.Data;

@Data
public class User {
    private Integer user_id;
    private String user_name;
    private String password;
}
