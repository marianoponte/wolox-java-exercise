package com.wolox.javaexercise.entity.permission;

import javax.persistence.*;

@Entity
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "album_id")
    private Integer albumId;

    @Column(name = "write")
    private Boolean write;

    @Column(name = "read")
    private Boolean read;

    public  Permission() {

    }

    public Permission(Integer id, Integer userId, Integer albumId, Boolean write, Boolean read) {
        super();
        this.id = id;
        this.userId = userId;
        this.albumId = albumId;
        this.write = write;
        this.read = read;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Boolean getWrite() {
        return write;
    }

    public void setWrite(Boolean write) {
        this.write = write;
    }

    public Boolean getRead() {
        return read;
    }

    public void setRead(Boolean read) {
        this.read = read;
    }
}