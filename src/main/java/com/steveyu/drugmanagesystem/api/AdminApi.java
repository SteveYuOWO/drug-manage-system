package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.entity.Admin;
import com.steveyu.drugmanagesystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/admin")
public class AdminApi {
    @Autowired
    AdminService adminService;

    @GetMapping("{page}/{size}")
    public Page<Admin> getAllAdmins(@PathVariable("page") int page,@PathVariable("size") int size) {
        return adminService.getAllAdmins(PageRequest.of(page, size));
    }

    @PostMapping
    public String saveAdmin(@RequestBody Admin admin) {
        adminService.saveAdmin(admin);
        return "插入成功";
    }

    @GetMapping("{id}")
    public Optional<Admin> getAdminById(@PathVariable("id") Integer id) {
        return adminService.getAdminById(id);
    }

    @DeleteMapping("{id}")
    public String deleteAdminById(@PathVariable("id") Integer id) {
        return adminService.deleteAdminById(id) ? "删除成功": "删除失败";
    }
}
