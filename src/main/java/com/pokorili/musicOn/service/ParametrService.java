package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.Parametrs;
import com.pokorili.musicOn.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ParametrService {
    @Autowired ConnectionService connectionService;

    public Parametrs getLast(Long id){
        Parametrs parameter;
        Gson gson = new Gson();

        try {
            String link = "http://localhost:8080/parametrs/" + id + "/last";
            parameter = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), Parametrs.class);
        } catch (IOException e) {
            e.printStackTrace();
            parameter = null;
        }
        return parameter;

    }

    public Parametrs addParameters(Parametrs parametrs) {
        Gson gson = new Gson();
        try {
            Users users = parametrs.getUsers();
            String link = "http://localhost:8080/parametrs/"+ users.getId();
            parametrs = gson.fromJson(connectionService.sendRequest(link,"POST", null, parametrs), Parametrs.class);
        } catch (IOException e) {
            e.printStackTrace();
            parametrs = null;
        }
        return parametrs;
    }

}
