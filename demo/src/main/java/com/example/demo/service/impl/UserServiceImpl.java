package com.example.demo.service.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.po.User;
import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @description 实现创建用户的接口
 * @create 2026/10/13 15:26
 */


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
    public void createUser(long id, String name) {
        User user = User.builder().id(id).name(name).build();
        userDao.insert(user);
    }
}
