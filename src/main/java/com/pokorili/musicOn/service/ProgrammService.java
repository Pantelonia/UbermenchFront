package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.entity.WeeklyDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProgrammService {
    @Autowired
    ConnectionService connectionService;
    public WeeklyDiet[] getAllProgramm(){
        WeeklyDiet[] programmes;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/Programm";
            programmes = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), WeeklyDiet[].class);
        } catch (IOException e) {
            e.printStackTrace();
            programmes = null;
        }

        return programmes;

    }

    public  WeeklyDiet[] getAllUserProgramm(Long id_user){
        WeeklyDiet[] userProgramm;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/MyProgramm/" + id_user;
            userProgramm = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), WeeklyDiet[].class);
        } catch (IOException e) {
            e.printStackTrace();
            userProgramm = null;
        }

        return userProgramm;

    }
}
