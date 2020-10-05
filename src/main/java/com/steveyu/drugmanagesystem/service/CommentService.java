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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    AdminDao adminDao;
    @Autowired
    UserDao userDao;
    @Autowired
    CommentDao commentDao;
    public Page<Comment> getCommentByAdminId(Integer id, Pageable pageable) {
        Optional<Admin> admin = adminDao.findById(id);
        return commentDao.findAll(Example.of(new Comment().
                setTo(admin.get())), pageable);
    }

    public void saveComment(CommentDto commentDto) {
        Optional<Admin> adminOptional = adminDao.findById(commentDto.getAdminId());
        Optional<User> userOptional = userDao.findById(commentDto.getUserId());
        commentDao.save(new Comment()
                .setMessage(commentDto.getMessage())
                .setFrom(userOptional.get())
                .setTo(adminOptional.get()));
    }

    public boolean deleteCommentById(Integer id) {
        Optional<Comment> comment = commentDao.findById(id);
        if(comment.isEmpty()) return false;
        commentDao.delete(comment.get());
        return true;
    }
}
