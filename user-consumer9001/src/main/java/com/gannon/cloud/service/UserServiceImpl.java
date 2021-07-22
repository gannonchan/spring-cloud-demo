package com.gannon.cloud.service;

import com.gannon.cloud.feign.UserFeignCilent;
import com.gannon.cloud.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

//    private final String USER_PROVIDER_URI = "http://cloud-user-provider";

    @Resource
    UserFeignCilent userFeignCilent;
    //    @Resource
//    private RestTemplate restTemplate;

    @Override
    public User findUserById(String id) {
//        User user = restTemplate.getForObject(USER_PROVIDER_URI + "/provider/users/id/" + id, User.class);
        User user = userFeignCilent.findUserById(id);
        return user;
    }

    @Override
    public List<User> listUser() {
        List<User> list = userFeignCilent.listUser();
        return list;
    }

    @Override
    public Integer insertUser(User user) {
        Integer count = userFeignCilent.insertUser(user);
        return count;
    }

    @Override
    public Integer updateUserById(User user) {
        Integer count = userFeignCilent.updateUserById(user);
        return count;
    }

    @Override
    public Integer deleteUserById(String id) {
        Integer count = userFeignCilent.deleteUserById(id);
        return count;
    }
}
