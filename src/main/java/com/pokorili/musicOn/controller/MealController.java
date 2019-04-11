package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.Meal;
import com.pokorili.musicOn.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class MealController {
    @Autowired
    MealService mealService;


    @GetMapping("/addMeal/{programm_id}")
    public String getChangeParametrsPage(Model model, @PathVariable Long programm_id){
       model.addAttribute("programm_id", programm_id);
        return "CreateMeal";
    }

    @PostMapping("/addMeal/{programm_id}")
        public String addMeal(@PathVariable Long programm_id, Model model, @RequestParam String name){
        DaillyMenu menu = mealService.getMenu(programm_id);
        Meal meal = new Meal();
        meal.setName(name);
        meal.setMenu(menu);
        mealService.addMeal(meal);
        return "activeProgrammPage";
        }


}
