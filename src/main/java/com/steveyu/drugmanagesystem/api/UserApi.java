package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.entity.User;
import com.steveyu.drugmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserApi {
    @Autowired
    UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
        if(userService.getUserByUsername(user.getUsername()).isEmpty()) {
            userService.saveUser(user);
            return "注册成功";
        } else {
            return "该用户已存在";
        }
    }

    @GetMapping("{id}")
    public Optional<User> getUserById(@PathVariable("id") Integer id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id) ? "删除成功": "删除失败";
    }
}
