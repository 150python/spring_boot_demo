package com.example.demo.dao;

import com.example.demo.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Administrator
 * @description 数据库方法接口
 * @create 2026/10/13 15:01
 */
@Mapper
public interface UserDao {
    void insert(User user);
}
