package com.mybucket.controller;

import com.mybucket.model.User;
import com.mybucket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
/*
    @PostMapping("/users")
    public User addUser(@RequestBody @Valid User user) {
        return  userService.addUser(user);
}*/
    @PostMapping("users")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
    userService.addUser(user);
    return ResponseEntity.ok("User data is valid");
        }
    @GetMapping("/user")
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("/user/{uid}")
    public User getUserById(@PathVariable("uid") int uid) {
        return userService.getUserById(uid);
    }

    @PutMapping("/user/{uid}")
    public User updateUser(@PathVariable("uid") int uid, @RequestBody User user) {
        return userService.updateUser(uid,user);
    }

    @DeleteMapping("/user/{uid}")
    public void deleteUser(@PathVariable("uid") int uid) {
        userService.deleteUser(uid);
    }
}
