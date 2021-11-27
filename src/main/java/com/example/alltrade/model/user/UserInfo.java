package com.example.alltrade.model.user;

import java.io.Serializable;

public class UserInfo extends User implements Serializable {
    private int id;
    private String country;
    private String lastAccessDate;
    private String role;

    public UserInfo(Integer id, String login, String password, String country, String lastAccessDate, String role) {
        super(login, password);
        this.id = id;
        this.country = country;
        this.lastAccessDate = lastAccessDate;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(String lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
