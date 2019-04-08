package com.pokorili.musicOn.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;


public class Users {

    private long id;

    private String login;


    private String password;


    private String email;

    @JsonIgnore
    private Collection<Parametrs> parametr;

    @JsonIgnore
    private Collection<UserWeekInstance> userWeekInstances;

    public Users() {

    }
    public Users(String login){
        this.login = login;
    }

    public Users(long id, String login, String password, String email) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Parametrs> getParametr() {
        return parametr;
    }

    public void setParametr(Collection<Parametrs> parametr) {
        this.parametr = parametr;
    }
}
