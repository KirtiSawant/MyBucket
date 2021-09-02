package com.mybucket.controller;


import com.mybucket.dto.UserDto;
import com.mybucket.model.User;
import com.mybucket.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@Validated
@RequestMapping("api")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    ModelMapper modelMapper;

    @PostMapping("user")
    public ResponseEntity<String> addUser(@RequestBody @Valid User user) {
    userService.addUser(user);
    return ResponseEntity.ok("User created successfully");
        }
    @GetMapping("/user")
    public List<UserDto> getUser() {
        return userService.getUser().stream().map(user -> modelMapper.map(user, UserDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("uid") int uid) {
        User user = userService.getUserById(uid);

        // convert entity to DTO
        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok().body(userResponse);

    }

    @PutMapping("/user/{uid}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("uid") int uid, @RequestBody UserDto userDto) {
        User userRequest = modelMapper.map(userDto, User.class);

        User user = userService.updateUser(uid, userRequest);

        // entity to DTO
        UserDto userResponse = modelMapper.map(user, UserDto.class);

        return ResponseEntity.ok().body(userResponse);
    }

    @DeleteMapping("/user/{uid}")
    public void deleteUser(@PathVariable("uid") int uid) {
        userService.deleteUser(uid);
    }
}
