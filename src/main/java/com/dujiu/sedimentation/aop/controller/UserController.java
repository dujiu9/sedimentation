package com.dujiu.sedimentation.aop.controller;

import com.dujiu.sedimentation.aop.annotation.Log;
import com.dujiu.sedimentation.aop.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dujiu
 * @date: 2025/9/23
 * @description: 用户控制器
 */
@RestController
public class UserController {

    @Log(desc = "用户登录接口")
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return "登录成功，用户：" + user.getName();
    }
}
