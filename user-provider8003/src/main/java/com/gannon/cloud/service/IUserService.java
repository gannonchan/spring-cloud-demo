package com.gannon.cloud.service;

import com.gannon.cloud.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IUserService {

    Integer deleteUserById(String id);

    Integer updateUserById(User user);

    Integer insertUser(User user);

    User findUserById(String id);

    List<User> listUser();

    Page<User> listUserPageAndSortWithDesc(Integer pageNum, Integer pageSize);
}
