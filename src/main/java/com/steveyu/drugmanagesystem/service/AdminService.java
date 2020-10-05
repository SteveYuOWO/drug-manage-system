package com.steveyu.drugmanagesystem.service;

import com.steveyu.drugmanagesystem.dao.AdminDao;
import com.steveyu.drugmanagesystem.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;

    public Page<Admin> getAllAdmins(Pageable pageable) {
        return adminDao.findAll(pageable);
    }

    public void saveAdmin(Admin admin) {
        adminDao.save(admin);
    }

    public Optional<Admin> getAdminById(Integer id) {
        return adminDao.findById(id);
    }

    public boolean deleteAdminById(Integer id) {
        Optional<Admin> adminOptional = adminDao.findById(id);
        if(adminOptional.isEmpty()) return false;
        adminDao.delete(adminOptional.get());
        return true;
    }
}
