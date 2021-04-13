package com.wolox.javaexercise.controller.photo;

import com.wolox.javaexercise.entity.photo.Photo;
import com.wolox.javaexercise.service.photo.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/photos")
public class PhotoController {
    @Autowired
    PhotoService photoService;

    //Get de "/photos" para mostrar todos las fotos
    @GetMapping
    public List<Photo> getPhotos() {
        return photoService.getPhotos();
    }
}
