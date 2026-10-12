package com.example.demo.controller;

import org.springframework.stereotype.Controller; // 注意这里改成了 @Controller
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test1 {

    @GetMapping("/a")
    public String showPage() {
        // 返回 "index"
        // Spring Boot 会自动去 src/main/resources/templates/ 下面寻找 index.html 并渲染返回
        return "a";
    }
}