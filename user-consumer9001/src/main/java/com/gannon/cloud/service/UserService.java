package com.gannon.cloud.service;

import com.gannon.cloud.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService {
    @GetMapping("/users/id/{id}")
    public User findUserById(@PathVariable("id")String id);
    @GetMapping("/users")
    public List<User> listUser();
    @PostMapping("/users")
    public Integer insertUser(@RequestBody User user);
    @PutMapping("/users")
    public Integer updateUserById(@RequestBody User user);
    @DeleteMapping("/users/id/{id}")
    public Integer deleteUserById(@PathVariable("id") String id);
}
