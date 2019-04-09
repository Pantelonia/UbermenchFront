package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.entity.WeeklyDiet;
import com.pokorili.musicOn.service.ProgrammService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes("user")
public class MyProgrammController{

    @Autowired
    ProgrammService programmService;

@GetMapping("/MyProgramm")
    public String getMyProgrammPage(Model model, @SessionAttribute("user") Users user){
        WeeklyDiet[] userProgramms = programmService.getAllUserProgramm(user.getId());
    model.addAttribute("userProgramms",userProgramms);
    return "myProgrammPage";
}

@GetMapping("/Programm")
    public  String getProgrammPage(Model model){
    WeeklyDiet[] programms = programmService.getAllProgramm();
    model.addAttribute("programms",programms);

    return "programmPage";
}
}
