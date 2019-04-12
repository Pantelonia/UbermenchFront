package com.pokorili.musicOn.service;

import com.google.gson.Gson;
import com.pokorili.musicOn.entity.CollectMeal;
import com.pokorili.musicOn.entity.Dish;
import com.pokorili.musicOn.entity.Meal;
import com.pokorili.musicOn.entity.WeeklyDiet;
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

//    public Dish addDish(Dish dish){
//
//        Gson gson = new Gson();
//        try {
//            String link = "http://localhost:8080/dish/add";
//            dish = gson.fromJson(connectionService.sendRequest(link, "POST", null, dish), Dish.class);
//        } catch (IOException e) {
//            e.printStackTrace();
//            dish = null;
//        }
//        return  dish;
//
//    }
public Dish[] getAllDish(){
    Dish[] dishes;
    Gson gson = new Gson();
    try {
        String link = "http://localhost:8080/dish";
        dishes = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), Dish[].class);
    } catch (IOException e) {
        e.printStackTrace();
        dishes = null;
    }

    return dishes;

}

 public CollectMeal getCollectMeal(Long id_meal, long id_dish){
    CollectMeal collectMeal;
    Gson gson = new Gson();
    try {
        String link = "http://localhost:8080/MyMeal/check/" + id_meal +"/" + id_dish;
        collectMeal = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), CollectMeal.class);
    } catch (IOException e) {
        e.printStackTrace();
        collectMeal = null;
    }

    return collectMeal;

}

    public CollectMeal addCollecrMeal(long meal_id, long dish_id){
        CollectMeal collectMeal;
        Gson gson = new Gson();
        try {
            String link = "http://localhost:8080/meal/"+ meal_id + "/dishes/add/" + dish_id;
            collectMeal = gson.fromJson(connectionService.sendRequest(link,"GET", null, null), CollectMeal.class);
        } catch (IOException e) {
            e.printStackTrace();
            collectMeal = null;
        }
        return collectMeal;
    }



    }
