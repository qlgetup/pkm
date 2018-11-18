package com.bupt.dao;
import com.bupt.model.User;

import java.util.List;

public interface UserDao {

   User login(String username);
   List<User> selectuser(String username);
   int regis(User user);
}
