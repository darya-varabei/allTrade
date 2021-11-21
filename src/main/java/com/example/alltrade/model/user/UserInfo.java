package com.example.alltrade.model.user;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {
    private int id;
    private String login;
    private String country;
    private Date lastAccessDate;
    private String role;

    public UserInfo(Integer id, String login, String country, Date lastAccessDate, String role) {
        this.id = id;
        this.login = login;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(Date lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
