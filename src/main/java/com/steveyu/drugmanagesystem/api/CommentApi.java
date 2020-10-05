package com.steveyu.drugmanagesystem.api;

import com.steveyu.drugmanagesystem.dto.CommentDto;
import com.steveyu.drugmanagesystem.entity.Comment;
import com.steveyu.drugmanagesystem.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comment")
public class CommentApi {
    @Autowired
    CommentService commentService;

    @GetMapping("{id}/{page}/{size}")
    public Page<Comment> getCommentByAdminId(@PathVariable("id") Integer id,
                                             @PathVariable("page") int page,
                                             @PathVariable("size") int size) {

        return commentService.getCommentByAdminId(id, PageRequest.of(page, size));
    }

    @PostMapping
    public String  saveComment(@RequestBody CommentDto commentDto) {
        commentService.saveComment(commentDto);
        return "插入成功";
    }

    @DeleteMapping("{id}")
    public String deleteCommentById(@PathVariable("id") Integer id) {
        return commentService.deleteCommentById(id) ? "删除成功": "删除失败";
    }
}
