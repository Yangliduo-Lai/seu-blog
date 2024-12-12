package com.app.backend.controller;

import com.app.backend.Service.UserService;
import com.app.backend.entity.User;
import com.app.backend.entity.Result;
import com.app.backend.utils.JwtUtil;
import com.app.backend.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        //查询用户
        User u = userService.findByUserName(username);

        if (u == null) { // 用户名没有被占用
            // 注册
            userService.register(username, password);
            return Result.success();
        } else {
            // 占用
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/accountlogin")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String username, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        // 判断该用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        // 判断密码是否正确
        if (Md5Util.getMD5String(password).equals(loginUser.getPassword())) {
            // 登录成功
            Map<String,Object> claims = new HashMap<>();
            claims.put("id",loginUser.getUser_id());
            claims.put("username",loginUser.getUser_name());
            String token = JwtUtil.genToken(claims);

            return Result.success(token);
        } else {
            return Result.error("密码错误");
        }
    }

    @PostMapping("/role")
    public Result<String> getRole(String username) {
        // 根据用户名查询用户
        User loginUser = userService.findByUserName(username);
        // 判断该用户是否存在
        if (loginUser == null) {
            return Result.error("用户名错误");
        }
        //返回用户类型
        return Result.success(userService.getRole(username));
    }
}
