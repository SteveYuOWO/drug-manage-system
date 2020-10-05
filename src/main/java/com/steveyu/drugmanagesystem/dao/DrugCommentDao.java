package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.DrugComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugCommentDao extends JpaRepository<DrugComment, Integer> {
}
