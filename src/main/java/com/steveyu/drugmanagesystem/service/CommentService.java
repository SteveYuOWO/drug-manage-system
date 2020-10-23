package com.steveyu.drugmanagesystem.service;

import com.steveyu.drugmanagesystem.dao.AdminDao;
import com.steveyu.drugmanagesystem.dao.CommentDao;
import com.steveyu.drugmanagesystem.dao.UserDao;
import com.steveyu.drugmanagesystem.dto.CommentDto;
import com.steveyu.drugmanagesystem.entity.Admin;
import com.steveyu.drugmanagesystem.entity.Comment;
import com.steveyu.drugmanagesystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;

    public List<Comment> getComment() {
        return commentDao.findAll();
    }

    public void saveComment(CommentDto commentDto) {
        Optional<User> userOptional = userDao.findById(commentDto.getUserId());
        commentDao.save(new Comment()
                .setMessage(commentDto.getMessage())
                .setFrom(userOptional.get()));
    }

    public boolean deleteCommentById(Integer id) {
        Optional<Comment> comment = commentDao.findById(id);
        if(comment.isEmpty()) return false;
        commentDao.delete(comment.get());
        return true;
    }
}
