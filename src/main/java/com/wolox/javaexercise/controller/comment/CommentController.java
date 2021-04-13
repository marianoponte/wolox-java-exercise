package com.wolox.javaexercise.controller.comment;

import com.wolox.javaexercise.entity.comment.Comment;
import com.wolox.javaexercise.service.comment.CommentService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    //Get de comentarios, pueden ser todos o filtrados por campo "name"
    @GetMapping
    public List<Comment> getComments(@RequestParam(required = false) String name) {
        if (Strings.isBlank(name)) {
            return commentService.getComments();
        } else {
            return commentService.getCommentsByName(name);
        }
    }
}