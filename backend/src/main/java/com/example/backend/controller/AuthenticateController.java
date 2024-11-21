package com.example.backend.controller;

import com.example.backend.entity.AuthenticationRequest;
import com.example.backend.entity.AuthenticationResponse;
import com.example.backend.util.JwtUtil;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

/**
 * 认证控制器，用于处理用户认证请求
 */
@CrossOrigin(origins = "*")
@RestController
@Scope("prototype")
@RequestMapping
public class AuthenticateController {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserDetailsService userDetailsService;

    /**
     * 创建认证令牌 *
     * @param authenticationRequest 包含用户凭据的认证请求
     * @return 包含JWT令牌的响应实体
     * @throws Exception 如果用户名或密码不正确抛出异常
     */
    @GetMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(AuthenticationRequest authenticationRequest) throws Exception {
        try{
            //尝试使用用户名和密码认证用户
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        } catch (Exception e) {
            //如果认证失败，抛出异常
            throw new Exception("Invalid username or password", e);
        }

        //加载用户详细信息
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        //生成JWT令牌
        final String jwtToken = jwtUtil.generateToken(userDetails.getUsername());
        //打印JWT令牌（调试目的）
        System.out.println(jwtToken);
        //返回包含JWT令牌的响应
        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }
}
