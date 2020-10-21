package com.steveyu.drugmanagesystem.service;

import com.steveyu.drugmanagesystem.dao.UserDao;
import com.steveyu.drugmanagesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public Optional<User> getUserById(Integer id) {
        return userDao.findById(id);
    }

    public boolean deleteUserById(Integer id) {
        Optional<User> userOptional = userDao.findById(id);
        if(userOptional.isEmpty()) return false;
        userDao.delete(userOptional.get());
        return true;
    }

    public Optional<User> getUserByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
