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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ActiveDayController {

    @Autowired
    ProgrammService programmService;
    @Autowired
    DailyMenuService dailyMenuService;
    @Autowired
    MealService mealService;

    @GetMapping("/activeDay/{programm_id}/{day_id}")
    public String getActiveDayPage(@PathVariable long programm_id, @PathVariable long day_id, Model model) {

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
