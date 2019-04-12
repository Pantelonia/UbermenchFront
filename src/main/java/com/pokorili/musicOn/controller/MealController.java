package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.Meal;
import com.pokorili.musicOn.entity.WeeklyDiet;
import com.pokorili.musicOn.service.DailyMenuService;
import com.pokorili.musicOn.service.MealService;
import com.pokorili.musicOn.service.ProgrammService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class MealController {
    @Autowired
    MealService mealService;
    @Autowired
    DailyMenuService dailyMenuService;
    @Autowired
    ProgrammService programmService;



    @GetMapping("/addMeal/{programm_id}/{day_id}")
    public String getChangeParametrsPage(Model model, @PathVariable Long programm_id,@PathVariable Long day_id){
       model.addAttribute("programm_id", programm_id);
       model.addAttribute("day_id", day_id);
        return "CreateMeal";
    }

    @PostMapping("/addMeal/{programm_id}/{day_id}")
        public String addMeal(@PathVariable Long programm_id, @PathVariable Long day_id, Model model, @RequestParam String name){
        DaillyMenu menu = dailyMenuService.getMenu(day_id);
        Meal meal = new Meal();
        meal.setName(name);
        meal.setMenu(menu);
        mealService.addMeal(meal);

        WeeklyDiet programm = programmService.getProgramm(programm_id);
        model.addAttribute("programm", programm);
        DaillyMenu daillyMenu = dailyMenuService.getMenu(day_id);
        model.addAttribute("daillyMenu", daillyMenu);
        Meal[] meals = mealService.getAllDayMeal(day_id);
        model.addAttribute("meals", meals);
        System.out.println(daillyMenu.getDay());
        return "ActiveDayPage";
        }


}
