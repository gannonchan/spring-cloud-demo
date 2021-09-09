package com.gannon.cloud.service.impl;

import com.gannon.cloud.dao.UserRepository;
import com.gannon.cloud.entity.User;
import com.gannon.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Integer deleteUserById(String id) {
        int count = 1;
        try {
            userRepository.deleteById(id);
        } catch (Exception e){
            count = 0;
        }
        return count;
    }

    @Override
    public Integer updateUserById(User user) {
        int count = 0;
        User result = userRepository.save(user);
        if (result == null) {
            count = 1;
        }
        return count;
    }

    @Override
    public Integer insertUser(User user) {
        int count = 0;
        User result = userRepository.save(user);
        if (result == null) {
            count = 1;
        }
        return count;
    }

    @Override
    public User findUserById(String id) {
        return userRepository.getOne(id);
    }

    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }

    @Override
    public Page<User> listUserPageAndSortWithDesc(Integer pageNum, Integer pageSize) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(order);
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        Page<User> page = userRepository.findAll(pageable);
        return page;
    }
}
