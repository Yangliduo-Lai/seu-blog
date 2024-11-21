package com.example.backend.entity;

public class AuthenResponse {
    private final String jwt;
    public AuthenResponse(String jwt) {
        this.jwt = jwt;
    }
    public String getJwt() {
        return jwt;
    }
}
