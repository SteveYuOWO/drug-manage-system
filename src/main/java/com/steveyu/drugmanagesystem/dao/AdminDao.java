package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin, Integer> {
}
