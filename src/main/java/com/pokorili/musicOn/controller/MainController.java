package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Genre;
import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.Soundtrack;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.pokorili.musicOn.entity.Visitor;
import com.pokorili.musicOn.service.PlaylistService;
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

    @Autowired
    PlaylistService playlistService;

    @GetMapping("/")
    public String getMainPage(Model model) {
        model.addAttribute("title", "test");
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

    @GetMapping("/searchbyplaylist")
    public String getPlaylistSearch(@RequestParam(value = "title") String title, Model model){
        Playlist[] playlistList = playlistService.getPlaylists(title);
        model.addAttribute("searchtype", "playlist");
        model.addAttribute("searchList", playlistList);
        model.addAttribute("title", title);
        return "searchPage";
    }
    @GetMapping("/searchbyauthor")
    public String getSongByAuthor(@RequestParam(value = "title") String title, Model model){

        Soundtrack[] soundtrackList = soundtrackService.getSoundtracksByAuthor(title);
        model.addAttribute("searchtype", "soundtrackByTitle");
        model.addAttribute("title", title);
        model.addAttribute("searchList", soundtrackList);
        return "searchPage";
    }
}
