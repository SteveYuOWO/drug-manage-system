package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.entity.User;
import com.steveyu.drugmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserApi {
    @Autowired
    UserService userService;

    @GetMapping("{page}/{size}")
    public Page<User> getAllUsers(@PathVariable("page") int page, @PathVariable("size") int size) {
        return userService.getAllUsers(PageRequest.of(page, size));
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return "插入成功";
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
