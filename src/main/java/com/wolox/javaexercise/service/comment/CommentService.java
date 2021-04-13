package com.wolox.javaexercise.service.comment;

import com.wolox.javaexercise.entity.comment.Comment;
import com.wolox.javaexercise.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    RestTemplate restTemplate;

    //Get de todos los comentarios
    public List<Comment> getComments() {
        Comment[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_COMMENTS, Comment[].class);
        List<Comment> comments = Arrays.asList(response);
        return comments;
    }

    //Get de comentarios filtrado por campo "name"
    public List<Comment> getCommentsByName(String name) {
        Comment[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_COMMENTS + "?name=" + name, Comment[].class);
        List<Comment> comments = Arrays.asList(response);
        return comments;
    }

}
