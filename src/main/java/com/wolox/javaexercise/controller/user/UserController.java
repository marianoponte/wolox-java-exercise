package com.wolox.javaexercise.controller.user;

import com.wolox.javaexercise.entity.album.Album;
import com.wolox.javaexercise.entity.comment.Comment;
import com.wolox.javaexercise.entity.photo.Photo;
import com.wolox.javaexercise.entity.user.User;
import com.wolox.javaexercise.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    //Get de "/users" para mostrar todos los usuarios
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    //Get de albums de un usuario
    @GetMapping("/{userId}/albums")
    public List<Album> getAlbumsByUser(@PathVariable Integer userId) {
        return userService.getAlbumsByUser(userId);
    }

    //Get de fotos de un usuario
    @GetMapping("/{userId}/photos")
    public List<Photo> getPhotosByUser(@PathVariable Integer userId) {
        return userService.getPhotosByUser(userId);
    }

    //Get de comentarios de un usuario
    @GetMapping("/{userId}/comments")
    public List<Comment> getCommentsByUser(@PathVariable Integer userId) {
        return userService.getCommentsByUser(userId);
    }
}