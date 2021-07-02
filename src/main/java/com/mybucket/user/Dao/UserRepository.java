package com.mybucket.user.Dao;

import com.mybucket.user.model.User;

import java.util.List;



public interface UserRepository {

          User saveUser(User user);
          User updateUser(User user);
          User getById(int id);
          String  deleteById(int id);
          List<User> allUsers();
}
