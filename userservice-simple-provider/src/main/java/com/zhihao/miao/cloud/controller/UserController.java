package com.zhihao.miao.cloud.controller;

import com.zhihao.miao.cloud.entity.User;
import com.zhihao.miao.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return userService.findOne(id);

    }

}
