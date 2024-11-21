package com.example.backend.controller;

import com.example.backend.entity.User;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class UserController {
    @Resource
    private com.example.backend.service.UserService UserService;

    @ResponseBody
    @RequestMapping("/list")
    public Object queryList() {
        return this.UserService.findAll(null);
    }

    public Object queryList2(User User) {
        return this.UserService.findAll(User);
    }
}
