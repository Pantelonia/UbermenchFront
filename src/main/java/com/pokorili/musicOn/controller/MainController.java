package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.Soundtrack;

import com.pokorili.musicOn.service.PlaylistService;
import com.pokorili.musicOn.service.SoundtrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    SoundtrackService soundtrackService;

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public String getMainPage(Model model){
        return "mainPage";
    }
    @PostMapping("/")
    public String getAuthMainPage(Model model) {
        return "mainPage";
    }
    @GetMapping("/search")
    public String getSearchResults(@RequestParam(value = "title") String title,
                                   @RequestParam(value = "searchtype") String searchtype, Model model) {

        switch (searchtype){
            case "playlist":
                Playlist[] playlistList = playlistService.getPlaylists(title);
                model.addAttribute("searchtype", "playlist");
                model.addAttribute("searchList", playlistList);
                model.addAttribute("title", title);
                break;
            case "soundtrackByTitle":
                Soundtrack[] soundtrackList = soundtrackService.getSoundtracksByTitle(title);
                model.addAttribute("searchtype", "soundtrackByTitle");
                model.addAttribute("title", title);
                model.addAttribute("searchList", soundtrackList);
                break;
            case "soundtrackByAuthor":
                soundtrackList = soundtrackService.getSoundtracksByAuthor(title);
                model.addAttribute("searchtype", "soundtrackByAuthor");
                model.addAttribute("title", title);
                model.addAttribute("searchList", soundtrackList);
                break;
        }
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
