package com.gannon.cloud.controller;

import com.gannon.cloud.dao.UserDao;
import com.gannon.cloud.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/provider")
public class UserController {

    @Value("${server.port}")
    private String port;
    @Resource
    private UserDao userDao;
    @GetMapping("/users/id/{id}")
    public User findUserById(@PathVariable("id") String id){
        User user = userDao.findUserById(id);
        return user;
    }
    @GetMapping("/users")
    public List<User> listUser(){
        List<User> list = userDao.listUser();
        return list;
    }
    @PostMapping("/users")
    public Integer insertUser(@RequestBody User user){
        Integer count = userDao.insertUser(user);
        return count;
    }
    @PutMapping("/users")
    public Integer updateUserById(@RequestBody User user){
        Integer count = userDao.updateUserById(user);
        return count;
    }
    @DeleteMapping("/users/id/{id}")
    public Integer deleteUserById(@PathVariable("id") String id){
        Integer count = userDao.deleteUserById(id);
        return count;
    }
}
