package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.UserWeekInstance;
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

    public WeeklyDiet getProgramm(long id){
        WeeklyDiet programm;
        Gson gson = new Gson();
        try {
            System.out.println("id_programm" + id);
            String link = "http://localhost:8080/Programm/" + id;
            programm = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), WeeklyDiet.class);
        } catch (IOException e) {
            e.printStackTrace();
            programm = null;
        }

        return programm;


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
    public UserWeekInstance getUserProgrammInstance(Long id_user, long id_week){
        UserWeekInstance userWeekInstance;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/MyProgramm/check/" + id_user +"/" + id_week;
            userWeekInstance = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), UserWeekInstance.class);
        } catch (IOException e) {
            e.printStackTrace();
            userWeekInstance = null;
        }

        return userWeekInstance;

    }


    public WeeklyDiet addUserProgramm(long id_user, long id_programm){
        WeeklyDiet userProgramm;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/MyProgramm/add/" + id_user + "/" + id_programm;
            userProgramm = gson.fromJson(connectionService.sendRequest(link,"POST", null, null), WeeklyDiet.class);
        } catch (IOException e) {
            e.printStackTrace();
            userProgramm = null;
        }

        return userProgramm;
    }
}
