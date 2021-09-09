package com.gannon.cloud.service;

import com.gannon.cloud.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserService {
    User findUserById(@PathVariable("id") String id);

    List<User> listUser();

    Page<User> listUserPageAndSortWithDesc(Integer pageNum, Integer pageSize);

    Integer insertUser(@RequestBody User user);

    Integer updateUserById(@RequestBody User user);

    Integer deleteUserById(@PathVariable("id") String id);
}
