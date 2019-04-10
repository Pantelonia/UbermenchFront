package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.WeeklyDiet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DailyMenuService {
    @Autowired ConnectionService connectionService;

    public DaillyMenu[] getAllProgrammDay(long id_programm){
        DaillyMenu[] daillyMenus;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/Programm/" + id_programm + "/days/";
            daillyMenus = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), DaillyMenu[].class);
        } catch (IOException e) {
            e.printStackTrace();
            daillyMenus = null;
        }

        return daillyMenus;

    }
}
