package com.example.alltrade.model.user;

import com.example.alltrade.model.country.Country;

public class CurrentUser extends User {

    private static CurrentUser instance;
    private Country country;
    private String lastAccessDate;

    private CurrentUser(String login, String password, Country country, String role) {
        super(login, password, role);
        this.country = country;
    }

    public CurrentUser() {
        super("", "", "");
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getLastAccessDate() {
        return lastAccessDate;
    }

    public void setLastAccessDate(String lastAccessDate) {
        this.lastAccessDate = lastAccessDate;
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
