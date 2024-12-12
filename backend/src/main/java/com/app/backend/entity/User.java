package com.app.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
    public enum Role { user, blogger, admin }

    @NotNull
    private Integer userid;
    private String username;
    @JsonIgnore // json字符串忽略password
    private String password;
    @NotEmpty
    @Email
    private String email;
    private Role role;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private String avatar;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,100}$")
    private String signature;
}
