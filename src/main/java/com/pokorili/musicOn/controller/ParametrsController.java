package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Parametrs;
import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.service.ParametrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class ParametrsController {
    @Autowired
    ParametrService parametrService;

    @ModelAttribute("newParam")
    public Parametrs createNewParameters() {
        return new Parametrs();
    }


    @GetMapping("/changeParametrs")
    public String getChangeParametrsPage(Model model, @SessionAttribute("user") Users user){
        return "paramPage";
    }

    @PostMapping("/addParametrs")
    public  String changeParametrs(@ModelAttribute("newParam") Parametrs newParam, @SessionAttribute("user") Users user, Model model ){

        model.addAttribute("parametrs", newParam);
        parametrService.addParameters(newParam);

        return "profilePage";
    }



}
