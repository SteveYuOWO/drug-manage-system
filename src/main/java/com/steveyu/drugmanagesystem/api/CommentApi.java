package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.dto.CommentDto;
import com.steveyu.drugmanagesystem.entity.Comment;
import com.steveyu.drugmanagesystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/comment")
public class CommentApi {
    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> getComment() {

        return commentService.getComment();
    }

    @PostMapping
    public String  saveComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto);
        return "留言成功";
    }

    @DeleteMapping("{id}")
    public String deleteCommentById(@PathVariable("id") Integer id) {
        return commentService.deleteCommentById(id) ? "删除成功": "删除失败";
    }
}
