package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminDao extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByUsername(String username);
}
