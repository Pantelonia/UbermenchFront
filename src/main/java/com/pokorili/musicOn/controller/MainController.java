package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Soundtrack;
import com.pokorili.musicOn.service.SoundtrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    SoundtrackService soundtrackService;

    @GetMapping("/")
    public String getMainPage(Model model){
        return "mainPage";
    }
    @PostMapping("/")
    public String getAuthMainPage(Model model) {
        return "mainPage";
    }
    @PostMapping("/search")
    public String getSearchResults(@RequestParam(value = "title") String title, Model model) {
        Soundtrack[] soundtrackList = soundtrackService.getSoundtracksByTitle(title);
        model.addAttribute("soundtrackList", soundtrackList);
        return "searchPage";
    }
    @GetMapping("/login")
    public String getLoginPage(Model model) {
        return "loginPage";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        return "registerPage";
    }
}
