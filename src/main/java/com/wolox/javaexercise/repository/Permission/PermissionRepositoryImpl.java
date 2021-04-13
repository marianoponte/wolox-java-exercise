package com.wolox.javaexercise.repository.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PermissionRepositoryImpl {

    @Autowired
    PermissionRepository permissionRepository;

}
