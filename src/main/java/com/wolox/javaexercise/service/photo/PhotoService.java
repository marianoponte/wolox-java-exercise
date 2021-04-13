package com.wolox.javaexercise.service.photo;

import com.wolox.javaexercise.entity.photo.Photo;
import com.wolox.javaexercise.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PhotoService {
    @Autowired
    RestTemplate restTemplate;

    //Get de todas las fotos
    public List<Photo> getPhotos() {
        Photo[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_PHOTOS, Photo[].class);
        List<Photo> photos = Arrays.asList(response);
        return photos;
    }
}
