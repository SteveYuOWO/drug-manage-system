package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugDao extends JpaRepository<Drug, Integer> {
}
