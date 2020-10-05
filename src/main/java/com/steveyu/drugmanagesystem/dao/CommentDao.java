package com.steveyu.drugmanagesystem.dao;

import com.steveyu.drugmanagesystem.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment, Integer> {

}
