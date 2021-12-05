package com.example.alltrade.model.user;

import com.example.alltrade.connector.Connection;

import java.io.Serializable;

public class UserInfo extends User implements Serializable {
    private int id;
    private String country;
    private String lastAccessDate;

    public UserInfo(Integer id, String login, String password, String country, String lastAccessDate, String role) {
        super(login, password, role);
        this.id = id;
        this.country = country;
        this.lastAccessDate = lastAccessDate;
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

    public String addUser() {
        String response = "";
        Connection.usersManager.sendObject("addUser", this);
        response = Connection.connectionManager.readString();
        return response;
    }

    public String updateUser() {
        String response = "";
        Connection.connectionManager.sendObject("updateUser", this);
        response = Connection.connectionManager.readString();
        return response;
    }
}
