package com.wolox.javaexercise.service.permission;

import com.wolox.javaexercise.entity.permission.Permission;
import com.wolox.javaexercise.repository.Permission.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    //Create permiso para un album
    public Permission createPermissionForAlbum(Permission permission) {
        return permissionRepository.save(permission);
    }
}
