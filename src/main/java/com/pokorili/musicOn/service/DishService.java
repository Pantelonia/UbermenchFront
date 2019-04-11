package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.Dish;
import com.pokorili.musicOn.entity.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DishService {
    @Autowired
    ConnectionService connectionService;

    public Dish[] getAllMealsDishes(long meal_id) {
        Dish[] dishes;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/meal/" + meal_id + "/dishes";
            dishes = gson.fromJson(connectionService.sendRequest(link, "GET", null, null), Dish[].class);
        } catch (IOException e) {
            e.printStackTrace();
            dishes = null;
        }

        return dishes;
    }

}
