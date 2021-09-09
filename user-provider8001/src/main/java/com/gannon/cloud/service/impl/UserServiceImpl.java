package com.gannon.cloud.service.impl;

import com.gannon.cloud.dao.UserDao;
import com.gannon.cloud.entity.User;
import com.gannon.cloud.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Resource
    private UserDao userDao;

    @Override
    public Integer deleteUserById(String id) {
        return userDao.deleteUserById(id);
    }

    @Override
    public Integer updateUserById(User user) {
        return userDao.updateUserById(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User findUserById(String id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }

    @Override
    public Page<User> listUserPageAndSortWithDesc(Integer pageNum, Integer pageSize) {
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "id");
        Sort sort = Sort.by(order);
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
//        Page<User> page = userDao.listUserPageAndSortWithDesc(pageable);
        return null;
    }
}
