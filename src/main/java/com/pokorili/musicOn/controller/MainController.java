package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Genre;
import com.pokorili.musicOn.entity.Soundtrack;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.pokorili.musicOn.entity.Visitor;
import com.pokorili.musicOn.service.SoundtrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    SoundtrackService soundtrackService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("soundtrackTitle", "");
        return "mainPage";
    }
    @PostMapping("/search")
    public String getSearchResults(@RequestParam(value = "title") String title, Model model) {
        Soundtrack[] soundtrackList = soundtrackService.getSoundtracksByTitle(title);
        model.addAttribute("soundtrackList", soundtrackList);
        return "searchPage";
    }
}
