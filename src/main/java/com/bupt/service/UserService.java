package com.bupt.service;

import com.bupt.model.User;

import java.util.List;

public interface UserService {
    User login(String username);
    List<User> selectuser(String username);
    int regis(User user);
}