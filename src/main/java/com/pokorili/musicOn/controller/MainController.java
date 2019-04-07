package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Playlist;
import com.pokorili.musicOn.entity.Soundtrack;

import com.pokorili.musicOn.entity.Visitor;
import com.pokorili.musicOn.service.PlaylistService;
import com.pokorili.musicOn.service.SoundtrackService;
import com.pokorili.musicOn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@SessionAttributes("user")
public class MainController {

    @Autowired
    SoundtrackService soundtrackService;

    @Autowired
    PlaylistService playlistService;

    @Autowired
    UserService userService;

    @ModelAttribute("user")
    public Visitor createVisitor() {
        return new Visitor("UnAuth");
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
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
                Soundtrack[] soundtrackList = soundtrackService.getSoundtracksBy("title", title);
                model.addAttribute("searchtype", "soundtrackByTitle");
                model.addAttribute("title", title);
                model.addAttribute("searchList", soundtrackList);
                break;
            case "soundtrackByAuthor":
                soundtrackList = soundtrackService.getSoundtracksBy("author", title);
                model.addAttribute("searchtype", "soundtrackByAuthor");
                model.addAttribute("title", title);
                model.addAttribute("searchList", soundtrackList);
                break;
        }
        return "searchPage";
    }
    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("user") Visitor user, Model model) {
        Visitor searchVisitor = userService.getVisitorByNickname(user.getNickname());
        if (searchVisitor != null) {
            if (user.getPassword().equals(searchVisitor.getPassword())) {
                user.setStatus(searchVisitor.getStatus());
                user.setEmail(searchVisitor.getEmail());
                user.setId(searchVisitor.getId());
                return "mainPage";
            } else {
                model.addAttribute("errMessage", "Invalid password");
                return "loginPage";
            }
        } else {
            model.addAttribute("errMessage", "Invalid login");
            return "loginPage";
        }
    }
    @GetMapping("/logout")
    public String logout(@SessionAttribute("user")Visitor user) {
        Visitor defaultUser = createVisitor();
        user.setStatus(defaultUser.getStatus());
        user.setNickname(defaultUser.getNickname());
        user.setEmail(defaultUser.getEmail());
        user.setPassword(defaultUser.getPassword());
        return "mainPage";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        return "registerPage";
    }

    @GetMapping("/profile")
    public String getProfilePage() {
        return "profilePage";
    }
}
