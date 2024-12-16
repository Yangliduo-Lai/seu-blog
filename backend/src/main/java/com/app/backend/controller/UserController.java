package com.app.backend.controller;

import com.app.backend.Service.UserService;
import com.app.backend.entity.User;
import com.app.backend.entity.Result;
import com.app.backend.utils.JwtUtil;
import com.app.backend.utils.Md5Util;
import com.app.backend.utils.ThreadLocalUtil;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
            claims.put("id",loginUser.getUserid());
            claims.put("username", loginUser.getUsername());

            String token = JwtUtil.genToken(claims);

            String role = loginUser.getRole().toString();
            String json = String.format("{\"role\":\"%s\",\"token\":\"%s\"}", role, token);

            return Result.success(json);
        } else {
            return Result.error("密码错误");
        }
    }

    @GetMapping("/info")
    public Result<User> userInfo() {

        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");

        User user = userService.findByUserName(username);
        return Result.success(user);
    }

    @PutMapping("/info/update")
    public Result infoUpdate(@RequestBody @Validated User user) {
        userService.infoUpdate(user);
        return Result.success();
    }

    @PatchMapping("/avatar/update")
    public Result updateAvatar(@RequestParam @URL String avatarUrl){
        userService.updateAvatar(avatarUrl);
        return Result.success();
    }

    @PatchMapping("/password/update")
    public Result updatePwd(@RequestBody Map<String,String> params) {
        // 1. 校验参数
        String oldPassword = params.get("oldPassword");
        String newPassword = params.get("newPassword");
        String rePassword = params.get("rePassword"); // 确认密码

        System.out.println(StringUtils.hasLength(oldPassword));
        System.out.println(StringUtils.hasLength(newPassword));
        System.out.println(StringUtils.hasLength(rePassword));

        if (!(StringUtils.hasLength(oldPassword) || StringUtils.hasLength(newPassword) || StringUtils.hasLength(rePassword))) {
            return Result.error("缺少必要的参数");
        }

        // 校验原密码是否正确
        Map<String,Object> map = ThreadLocalUtil.get();
        String username = (String) map.get("username");
        User loginUser = userService.findByUserName(username);
        if (!loginUser.getPassword().equals(Md5Util.getMD5String(oldPassword))) {
            return Result.error("原密码填写不正确");
        }

        // newPwd 与 rePwd是否一样
        System.out.println(newPassword);
        System.out.println(rePassword);
        if (!rePassword.equals(newPassword)) {
            return Result.error("两次填写新密码不一致");
        }

        // 2. 调用 service 完成密码更新
        userService.updatePwd(newPassword);
        return Result.success();
    }

    @GetMapping("/logout")
    public Result<String> logout() {
        ThreadLocalUtil.remove();
        return Result.success("登出成功");
    }
}
