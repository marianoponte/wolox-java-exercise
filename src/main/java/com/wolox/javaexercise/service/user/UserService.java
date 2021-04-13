package com.wolox.javaexercise.service.user;

import com.wolox.javaexercise.entity.comment.Comment;
import com.wolox.javaexercise.entity.album.Album;
import com.wolox.javaexercise.entity.photo.Photo;
import com.wolox.javaexercise.entity.post.Post;
import com.wolox.javaexercise.entity.user.User;
import com.wolox.javaexercise.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    //Get de todos los usuarios
    public List<User> getUsers() {
        User[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_USERS, User[].class);
        List<User> users = Arrays.asList(response);
        return users;
    }

    //Get de todos los albums filtrados por usuario
    public List<Album> getAlbumsByUser(Integer userId) {
        Album[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_USERS + userId + "/albums", Album[].class);
        List<Album> albums = Arrays.asList(response);
        return albums;
    }

    //Get de todos los posts filtrados por usuario
    public  List<Post> getPostsByUser(Integer userId) {
        Post[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_USERS + userId + "/posts", Post[].class);
        List<Post> posts = Arrays.asList(response);
        return posts;
    }

    //Get de todas las fotos filtradss por usuario
    public List<Photo> getPhotosByUser(Integer userId) {
        List<Photo> photos = new ArrayList<Photo>();
        List<Album> albums = getAlbumsByUser(userId);
        //Lo mejor seria poder filtrar directamente en la API Externa con params por ejemplo: /photos?q=(userId in (1,2,n))
        albums.stream().forEach((album) -> {
            Photo[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_PHOTOS + "?albumId=" + album.getId(), Photo[].class);
            List<Photo> photosResponse = Arrays.asList(response);
            photos.addAll(photosResponse);
        });
        return photos;
    }

    //Get de todos los comentarios filtrados por usuario
    public List<Comment> getCommentsByUser(Integer userId) {
        List<Comment> comments = new ArrayList<Comment>();
        List<Post> posts = getPostsByUser(userId);
        //Lo mejor seria poder filtrar directamente en la API Externa con params por ejemplo: /postId?q=(userId in (1,2,n))
        posts.stream().forEach((post) -> {
            Comment[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_COMMENTS + "?postId=" + post.getId(), Comment[].class);
            List<Comment> commentsResponse = Arrays.asList(response);
            comments.addAll(commentsResponse);
        });
        return comments;
    }
}