package com.gannon.cloud.feign;

import com.gannon.cloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cloud-user-provider")
public interface UserFeignCilent {
    @GetMapping("/provider/users/id/{id}")
    public User findUserById(@PathVariable("id")String id);
    @GetMapping("/provider/users")
    public List<User> listUser();
    @GetMapping("/provider/users/page")
    public Page<User> listUserPageAndSortWithDesc(@RequestParam("page_num") Integer pageNum,
                      @RequestParam("size") Integer pageSize);
    @PostMapping("/provider/users")
    public Integer insertUser(@RequestBody User user);
    @PutMapping("/provider/users")
    public Integer updateUserById(@RequestBody User user);
    @DeleteMapping("/provider/users/id/{id}")
    public Integer deleteUserById(@PathVariable("id") String id);
}
