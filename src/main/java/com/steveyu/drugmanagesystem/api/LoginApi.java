package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.entity.Admin;
import com.steveyu.drugmanagesystem.entity.User;
import com.steveyu.drugmanagesystem.service.AdminService;
import com.steveyu.drugmanagesystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/login")
public class LoginApi {
    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @PostMapping("admin")
    public String adminLogin(@RequestBody Admin admin) {
        Optional<Admin> optionalAdmin = adminService.getAdminByName(admin.getUsername());
        if(optionalAdmin.isEmpty()) {
            return "用户不存在";
        } else {
            if(optionalAdmin.get().getPassword().equals(admin.getPassword())) {
                return "登录成功";
            } else {
                return "密码输入错误";
            }
        }
    }

    @PostMapping("common")
    public String commonUserLogin(@RequestBody User user) {
        Optional<User> optionalUser = userService.getUserByUsername(user.getUsername());
        if(optionalUser.isEmpty()) {
            return "用户不存在";
        } else {
            if(optionalUser.get().getPassword().equals(user.getPassword())) {
                return "登录成功";
            } else {
                return "密码输入错误";
            }
        }
    }
}