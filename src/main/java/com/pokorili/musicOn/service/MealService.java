package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.Meal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class MealService {
    @Autowired ConnectionService connectionService;

    public Meal addMeal(Meal meal) {
        Gson gson = new Gson();
        try {
            DaillyMenu daillyMenu = meal.getMenu();
            System.out.println(daillyMenu);
            String link = "http://localhost:8080/meal/add/"+ daillyMenu.getId();
            meal = gson.fromJson(connectionService.sendRequest(link,"POST", null, meal), Meal.class);

        } catch (IOException e) {
            e.printStackTrace();
            meal = null;
        }

        return meal;
    }

//    public DaillyMenu getMenu(long id){
//        DaillyMenu menu = new DaillyMenu();
//        Gson gson = new Gson();
//        try {
//            String link = "http://localhost:8080/menu/"+ id;
//             menu = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), DaillyMenu.class);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            menu = null;
//        }
//
//        return menu;
//
//    }

    public Meal[] getAllDayMeal(long day_id){
        Meal[] meals;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/day/"+ day_id +"/meals";
            meals = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), Meal[].class);
        } catch (IOException e) {
            e.printStackTrace();
            meals = null;
        }

        return meals;
    }



}
