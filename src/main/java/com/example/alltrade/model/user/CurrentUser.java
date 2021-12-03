package com.example.alltrade.model.user;

public class CurrentUser extends User {

    private static CurrentUser instance;
    private String country;
    private String role;

    private CurrentUser(String login, String password, String country, String role) {
        super(login, password);
        this.country = country;
        this.role = role;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public static CurrentUser getInstance(CurrentUser user) {//(String login, String password, String country, String role) {
        if (instance == null) {
            instance = new CurrentUser(user.login, user.password, user.country, user.role);
        }
        return instance;
    }

    public static CurrentUser getUser() {
        return instance;
    }

    public static void nullInstance() {
        instance = null;
    }
}
