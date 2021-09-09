package com.gannon.cloud.dao;

import com.gannon.cloud.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    User findUserById(String id);

    List<User> listUser();

    Integer insertUser(User user);

    Integer deleteUserById(String id);

    Integer updateUserById(User user);
}
