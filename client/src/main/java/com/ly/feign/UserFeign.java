package com.ly.feign;

import com.ly.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "user-service")
public interface UserFeign {

    @GetMapping("/user/login/{account}")
    public User getUser(@PathVariable("account") String account);

    @GetMapping("/user/findAll/{page}/{limit}")
    public List<User> findAllUsers(@PathVariable("page") int page, @PathVariable("limit") int limit);


    @GetMapping("/user/getUsersCount")
    public int getUsersCount();

    @GetMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable("id") int id);

}
