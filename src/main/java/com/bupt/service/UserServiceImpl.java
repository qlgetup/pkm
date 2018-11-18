package com.bupt.service;

import com.bupt.dao.UserDao;
import com.bupt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username) {
        return userDao.login(username);
    }
    @Override
    public List<User> selectuser(String username){
        return userDao.selectuser(username);
    }
    @Override
    public int regis(User user){
        try{
           return userDao.regis(user);
        }
        catch(Exception e){
            return -1;
        }
    }
}