package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
