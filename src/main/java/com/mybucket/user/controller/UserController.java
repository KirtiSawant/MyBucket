package com.mybucket.user.controller;

import com.mybucket.user.Dao.UserRepository;
import com.mybucket.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController

public class UserController {
    @Autowired
    UserRepository userRepository;
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/users")
    public ResponseEntity<String> addUser(@Valid @RequestBody  User user){
         userRepository.saveUser(user);
         return ResponseEntity.ok("User data is valid");
    }
    @PutMapping("/user")
    public User updateUser(@RequestBody  User user){
        return userRepository.updateUser(user);
    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") int id){
        return userRepository.getById(id);
    }
    @GetMapping("/user")
    public List<User> getUsers(){
        return userRepository.allUsers();
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userRepository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));
        return errors;
    }

}
