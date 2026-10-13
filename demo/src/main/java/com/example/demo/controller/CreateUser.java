package com.example.demo.controller;

import com.example.demo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateUser {

    @Resource
    private UserService userService;


    @GetMapping("/user/{name}/{id}/")
    public void insertUser(@PathVariable String name, @PathVariable Long id) {
        userService.createUser(id, name);
    }
}