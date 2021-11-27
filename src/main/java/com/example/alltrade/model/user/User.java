package com.example.alltrade.model.user;

import java.io.Serializable;

public class User implements Serializable {
    protected String login;
    protected String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String country) {
        this.password = password;
    }
}
