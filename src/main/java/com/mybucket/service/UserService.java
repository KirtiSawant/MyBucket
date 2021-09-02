package com.mybucket.service;

import com.amazonaws.services.frauddetector.model.ResourceNotFoundException;
import com.mybucket.exception.SprintNotFoundException;
import com.mybucket.exception.UserNotFoundException;
import com.mybucket.model.Sprint;
import com.mybucket.model.User;
import com.mybucket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        Optional<User> result = userRepository.findById(uid);
        if(result.isPresent()) {
            return result.get();
        }else {
            throw new UserNotFoundException(uid);
        }
    }
    public User updateUser (int uid,User userRequest){
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new UserNotFoundException(uid));
        user.setUserName(userRequest.getUserName());
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setEmail(userRequest.getEmail());
        user.setDob(userRequest.getDob());
        return userRepository.save(user);
    }

    public  void deleteUser(int uid){
        userRepository.deleteById(uid);
    }

}
