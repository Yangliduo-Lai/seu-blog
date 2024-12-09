package com.app.backend.controller;

import com.app.backend.entity.Result;
import com.app.backend.utils.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.MarshalledObject;
import java.util.Map;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @GetMapping("/list")
    public Result<String> list(/*@RequestHeader(name = "Authorization") String token, HttpServletResponse response*/) {
//        // 验证token
//        try {
//            Map<String,Object> claims = JwtUtil.parseToken(token);
//        } catch (Exception e) {
//            // http响应状态码为401
//            response.setStatus(401);
//            return Result.error("未登录");
//        }
        return Result.success("所有文章数据。。");
    }
}
