package com.zhihao.miao.cloud.service.impl;

import com.zhihao.miao.cloud.entity.User;
import com.zhihao.miao.cloud.repository.UserRepository;
import com.zhihao.miao.cloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }
}
