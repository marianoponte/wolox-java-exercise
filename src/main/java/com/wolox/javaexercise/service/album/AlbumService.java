package com.wolox.javaexercise.service.album;

import com.wolox.javaexercise.entity.album.Album;
import com.wolox.javaexercise.entity.permission.Permission;
import com.wolox.javaexercise.entity.user.User;
import com.wolox.javaexercise.repository.Permission.PermissionRepository;
import com.wolox.javaexercise.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AlbumService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PermissionRepository permissionRepository;

    //Get de todos los albums
    public List<Album> getAlbums() {
        Album[] response = restTemplate.getForObject(Constants.URL_SERVICE_REST_ALBUMS, Album[].class);
        List<Album> albums = Arrays.asList(response);
        return albums;
    }

    //Update de permiso para un album y usuario
    public Permission updatePermissionForAlbum(Integer albumdId, Permission permission) throws Exception {
        List<Permission> permissionOld = permissionRepository.findByAlbumIdAndUserId(albumdId, permission.getUserId());
        if (permissionOld != null && !permissionOld.isEmpty()) {
            Permission permissionToUpdate = permissionOld.get(0);
            permissionToUpdate.setWrite(permission.getWrite());
            permissionToUpdate.setRead(permission.getRead());
            return permissionRepository.save(permissionToUpdate);
        } else {
            throw new Exception("No se encontró registro para actualizar");
        }
    }

    //Get de usuarios por album y permisos
    public List<User> getUsersForAlbumAndPermissions(Integer albumId, Boolean write, Boolean read) {
        List<Permission> permissions = new ArrayList<Permission>();
        if (write != null && read != null ) {
            permissions = permissionRepository.findByAlbumIdAndWriteAndRead(albumId, write, read);
        } else if (write != null) {
            permissions = permissionRepository.findByAlbumIdAndWrite(albumId, write);
        } else if (read != null) {
            permissions = permissionRepository.findByAlbumIdAndRead(albumId, read);
        } else permissions = permissionRepository.findByAlbumId(albumId);

        List<User> users = getUsersByPermissions(permissions);
        return users;
    }

    //Get de usuarios por permisos
    public List<User> getUsersByPermissions(List<Permission> permissions) {
        List<User> users = new ArrayList<User>();
        permissions.stream().forEach((permission) -> {
            User userResponse = restTemplate.getForObject(Constants.URL_SERVICE_REST_USERS + permission.getUserId(), User.class);
            users.add(userResponse);
        });
        return users;
    }
}