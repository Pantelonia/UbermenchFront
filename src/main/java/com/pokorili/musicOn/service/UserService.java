package com.pokorili.musicOn.service;

import com.google.gson.Gson;

import com.pokorili.musicOn.entity.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    ConnectionService connectionService;

    public Users getUserByLogin(String login) {
        Users user;
        Map<String, String> params = new HashMap<>();
        params.put("login", login);
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/users/";
            user = gson.fromJson(connectionService.sendRequest(link,"GET", params, null), Users.class);
        } catch (IOException e) {
            e.printStackTrace();
            user = null;
        }

        return user;
    }

    public  Users getUserByEmail(String email){
        Users user;
        Map<String, String> params = new HashMap<>();
        params.put("email", email);
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/users/";
            user = gson.fromJson(connectionService.sendRequest(link,"GET", params, null), Users.class);
        } catch (IOException e) {
            e.printStackTrace();
            user = null;
        }

        return user;
    }


    public Users addVisitor(Users user) {
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/users";
            user = gson.fromJson(connectionService.sendRequest(link,"POST", null, user), Users.class);
        } catch (IOException e) {
            e.printStackTrace();
            user = null;
        }
        return user;
    }


    public Users changeUserProperty(Long id, String property, String value) {
        Users users;
        Map<String, String> params = new HashMap<>();
        params.put(property, value);
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/users" + "/" + id;
            users = gson.fromJson(connectionService.sendRequest(link,"POST", params, null), Users.class);
        } catch (IOException e) {
            e.printStackTrace();
            users = null;
        }
        return users;
    }


}
