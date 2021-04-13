package com.wolox.javaexercise.controller.album;

import com.wolox.javaexercise.entity.album.Album;
import com.wolox.javaexercise.entity.permission.Permission;
import com.wolox.javaexercise.entity.user.User;
import com.wolox.javaexercise.service.album.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
    @Autowired
    AlbumService albumService;

    //Get de "/albums" para mostrar todos los albums
    @GetMapping
    public List<Album> getAlbums() {
        return albumService.getAlbums();
    }

    //Update de permisos para un usuario en particular
    @PutMapping("/{albumId}/permissions")
    public ResponseEntity<Permission> updatePermissionForAlbum(@PathVariable Integer albumId, @RequestBody Permission permission) {
        try {
            Permission permissionUpdated = albumService.updatePermissionForAlbum(albumId, permission);
            return new ResponseEntity<>(permissionUpdated,HttpStatus.OK);
        }
        catch (Exception e) {
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Get de todos los usuarios que tienen un permiso determinado (read y write)
    @GetMapping("/{albumId}/users")
    public List<User> getUsersForAlbumAndPermissions(@PathVariable Integer albumId, @RequestParam(required = false) Boolean write, @RequestParam(required = false) Boolean read) {
        return albumService.getUsersForAlbumAndPermissions(albumId, write, read);
    }
}
