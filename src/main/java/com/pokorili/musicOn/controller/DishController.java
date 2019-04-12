package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.*;
import com.pokorili.musicOn.service.DishService;
import com.pokorili.musicOn.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class DishController {

    @Autowired
    DishService dishService;
    @Autowired
    MealService mealService;


    @GetMapping("/chooseMyDish/{meal_id}")
    public String chooseUserDish(@PathVariable long meal_id, Model model) {
        Meal meal = mealService.getMeal(meal_id);
        Dish[] dishes = dishService.getAllDish();
        model.addAttribute("dishes", dishes);
        model.addAttribute("meal", meal);
        return "AddMealDishPage";

    }

    @GetMapping("/addMealDish/{meal_id}/{dish_id}")
    public String addMealDish(@PathVariable Long meal_id, @PathVariable long dish_id, Model model) {
        CollectMeal collectMeal = dishService.getCollectMeal(meal_id, dish_id);
        if (collectMeal == null) {
            CollectMeal collectMeal1 = dishService.addCollecrMeal(meal_id, dish_id);
            Dish[] dishes = dishService.getAllMealsDishes(meal_id);
            Meal meal = mealService.getMeal(meal_id);
            model.addAttribute("meal", meal);
            model.addAttribute("dishes", dishes);
            return "ActiveMealPage";
        } else {
            model.addAttribute("errMessage", "You have this programm yet");
            Meal meal = mealService.getMeal(meal_id);
            Dish[] dishes = dishService.getAllDish();
            model.addAttribute("dishes", dishes);
            model.addAttribute("meal", meal);
            return "AddMealDishPage";


        }
    }
}
