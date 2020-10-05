package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
}
