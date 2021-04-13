package com.wolox.javaexercise.entity.user;

import com.wolox.javaexercise.entity.user.info.UserAddress;
import com.wolox.javaexercise.entity.user.info.UserCompany;

public class User {

    private Integer id;

    private String name;

    private String username;

    private String email;

    private UserAddress address;

    private String phone;

    private String website;

    private UserCompany company;

    public User() {

    }

    public User(Integer id, String name, String userName, String email, UserAddress address, String phone, String webSite, UserCompany company) {
        super();
        this.id = id;
        this.name = name;
        this.username = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = webSite;
        this.company = company;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserAddress getAddress() {
        return address;
    }

    public void setAddress(UserAddress address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public UserCompany getCompany() {
        return company;
    }

    public void setCompany(UserCompany company) {
        this.company = company;
    }
}