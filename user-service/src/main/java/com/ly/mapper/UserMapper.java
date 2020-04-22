package com.ly.mapper;

import com.ly.entity.User;

import java.util.List;

public interface UserMapper {
    public List<User> findAllUser(int index, int limit);
    public int countUser();
    public void addUser(User user);
    public void deleteById(int id);
    public User getUserByAccount(String account);
}