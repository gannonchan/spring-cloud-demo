package com.gannon.cloud.controller;

import com.gannon.cloud.entity.User;
import com.gannon.cloud.service.UserService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
@RefreshScope
public class UserController {

    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    UserService userService;

    @GetMapping("/users/id/{id}")
    public User findUserById(@PathVariable("id") String id){
        User user = userService.findUserById(id);
        return user;
    }
    @GetMapping("/users")
    public List<User> listUser(){
        List<User> list = userService.listUser();
        return list;
    }

    @GetMapping("/users/page")
    public Page<User> listUserPageAndSortWithDesc(@RequestParam("page_num") Integer pageNum, @RequestParam("size") Integer pageSize){
        Page<User> page = userService.listUserPageAndSortWithDesc(pageNum, pageSize);
        return page;
    }

    @PostMapping("/users")
    public Integer insertUser(@RequestBody User user){
        Integer count = userService.insertUser(user);
        return count;
    }
    @PutMapping("/users")
    public Integer updateUserById(@RequestBody User user){
        Integer count = userService.updateUserById(user);
        return count;
    }
    @DeleteMapping("/users/id/{id}")
    public Integer deleteUserById(@PathVariable("id") String id){
        Integer count = userService.deleteUserById(id);
        return count;
    }
}
