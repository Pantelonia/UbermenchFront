package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.DaillyMenu;
import com.pokorili.musicOn.entity.UserWeekInstance;
import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.entity.WeeklyDiet;
import com.pokorili.musicOn.service.DailyMenuService;
import com.pokorili.musicOn.service.ProgrammService;
import org.apache.jasper.tagplugins.jstl.core.If;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user")
public class MyProgrammController{

    @Autowired
    ProgrammService programmService;
    @Autowired
    DailyMenuService dailyMenuService;


@GetMapping("/MyProgramm")
    public String getMyProgrammPage(Model model, @SessionAttribute("user") Users user){
        WeeklyDiet[] userProgramms = programmService.getAllUserProgramm(user.getId());
    model.addAttribute("userProgramms",userProgramms);
    return "allMyProgrammPage";
}

@GetMapping("/Programm")
    public  String getProgrammPage(Model model){
    WeeklyDiet[] programms = programmService.getAllProgramm();
    model.addAttribute("programms",programms);

    return "programmStorePage";
}
@GetMapping("/Programm/{id}")
    public  String getCurrentProgamms(@PathVariable long id, Model model){
    WeeklyDiet programm = programmService.getProgramm(id);
    DaillyMenu[] daillyMenus = dailyMenuService.getAllProgrammDay(programm.getId());
    model.addAttribute("days", daillyMenus);
    model.addAttribute("programm", programm);
    return "activeProgrammPage";

}

@GetMapping("/chooseMyProgramm")
    public  String chooseUserProgramm(Model model){
    WeeklyDiet[] programms = programmService.getAllProgramm();
    model.addAttribute("programms",programms);
return "addUserProgrammPage";

}

@GetMapping("/addMyProgramm/{id}")
    public String AddUserProgramm(@PathVariable Long id, @SessionAttribute("user") Users user, Model model){
    UserWeekInstance userWeekInstance = programmService.getUserProgrammInstance(user.getId(), id);
    if (userWeekInstance == null ){
        WeeklyDiet programm = programmService.addUserProgramm(user.getId(), id);
        WeeklyDiet[] userProgramms = programmService.getAllUserProgramm(user.getId());
        model.addAttribute("userProgramms",userProgramms);
        return "allMyProgrammPage";
    }
    else{
        model.addAttribute("errMessage", "You have this programm yet");
        WeeklyDiet[] programms = programmService.getAllProgramm();
        model.addAttribute("programms",programms);
        return "addUserProgrammPage";

    }



}

}
