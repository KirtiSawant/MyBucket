package com.mybucket.service;

import com.mybucket.model.User;
import com.mybucket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }
    public List<User> getUser() {
        return (List<User>) userRepository.findAll();
    }
    public User getUserById(int uid){
        return userRepository.findById(uid).get();
    }
    public User updateUser (int uid,User user){
        user.setUid(uid);
        return   userRepository.save(user);
    }
    public  void deleteUser(int uid){
        userRepository.deleteById(uid);
    }

}
