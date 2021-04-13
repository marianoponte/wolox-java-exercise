package com.wolox.javaexercise.controller.permission;

import com.wolox.javaexercise.entity.permission.Permission;
import com.wolox.javaexercise.service.permission.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    PermissionService permissionService;

    //Create de permisos para un usuario y un album
    @PostMapping
    public Permission createPermissionForAlbum(@RequestBody Permission permission) {
        return permissionService.createPermissionForAlbum(permission);
    }

}
