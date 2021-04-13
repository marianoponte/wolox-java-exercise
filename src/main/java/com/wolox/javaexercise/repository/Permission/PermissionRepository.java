package com.wolox.javaexercise.repository.Permission;

import com.wolox.javaexercise.entity.permission.Permission;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionRepository extends CrudRepository<Permission,Long> {

    List<Permission> findByAlbumId(Integer albumId);

    List<Permission> findByAlbumIdAndUserId(Integer albumId, Integer userId);

    List<Permission> findByAlbumIdAndWrite(Integer albumId, Boolean write);

    List<Permission> findByAlbumIdAndRead(Integer albumId, Boolean read);

    List<Permission> findByAlbumIdAndWriteAndRead(Integer albumId, Boolean write, Boolean read);

}
