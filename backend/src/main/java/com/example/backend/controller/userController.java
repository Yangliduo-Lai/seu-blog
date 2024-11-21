package com.example.backend.controller;

import com.example.backend.entity.user;
import com.example.backend.service.userService;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
@RequestMapping("/user")
public class userController {
    @Resource
    private userService UserService;

    @ResponseBody
    @RequestMapping("/list")
    public Object queryList() {
        return this.UserService.findAll(null);
    }

    public Object queryList2(user User) {
        return this.UserService.findAll(User);
    }
}
