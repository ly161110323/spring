package com.ly.controller;

import com.ly.entity.User;
import com.ly.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login/{account}")
    public User getUser(@PathVariable("account") String account)
    {
        return userMapper.getUserByAccount(account);
    }

    @GetMapping("/findAll/{page}/{limit}")
    public List<User> findAllUsers(@PathVariable("page") int page, @PathVariable("limit") int limit)
    {
         return userMapper.findAllUser((page-1)*limit, limit);
    }

    @GetMapping("/getUsersCount")
    public int getUsersCount()
    {
        return userMapper.countUser();
    }

    @GetMapping("/delete/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userMapper.deleteById(id);
    }
}
