package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Visitor;
import com.pokorili.musicOn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
public class ProfileController {

    @Autowired
    UserService userService;

    @ModelAttribute("newUser")
    public Visitor createNewVisitor() {
        return new Visitor();
    }

    @GetMapping("/profile")
    public String getProfilePage() {
        return "profilePage";
    }

    @GetMapping("/changeEmail")
    public String getChangeEmailPage(Model model) {
        model.addAttribute("setting", "email");
        return "changeProfileSettingsPage";
    }

    @PostMapping("/changeEmail")
    public String changeEmail(@SessionAttribute("user")Visitor curUser, @ModelAttribute("newUser")Visitor newUser, Model model) {
        Visitor checkVisitor = userService.getVisitorByEmail(newUser.getEmail());
        if (checkVisitor != null) {
            model.addAttribute("errMessage", "This email is already registered");
            model.addAttribute("setting", "email");
            return "changeProfileSettingsPage";
        } else {
            curUser.setEmail(newUser.getEmail());
            userService.changeVisitorProperty(curUser.getId(), "email", newUser.getEmail());
            model.addAttribute("infoMessage", "Email successfully changed!");
            return "profilePage";
        }
    }

    @GetMapping("/changeNickname")
    public String getChangeNicknamePage(Model model) {
        model.addAttribute("setting", "nickname");
        return "changeProfileSettingsPage";
    }

    @PostMapping("/changeNickname")
    public String changeNickname(@SessionAttribute("user")Visitor curUser, @ModelAttribute("newUser")Visitor newUser, Model model) {
        Visitor checkVisitor = userService.getVisitorByNickname(newUser.getNickname());
        if (checkVisitor != null) {
            model.addAttribute("errMessage", "This nickname is already registered");
            model.addAttribute("setting", "nickname");
            return "changeProfileSettingsPage";
        } else {
            curUser.setNickname(newUser.getNickname());
            userService.changeVisitorProperty(curUser.getId(), "nickname", newUser.getNickname());
            model.addAttribute("infoMessage", "Nickname successfully changed!");
            return "profilePage";
        }
    }

    @GetMapping("/changePassword")
    public String getChangePasswordPage(Model model) {
        model.addAttribute("setting", "password");
        return "changeProfileSettingsPage";
    }

    @PostMapping("/changePassword")
    public String changePassword(@SessionAttribute("user")Visitor curUser, @ModelAttribute("newUser")Visitor newUser, Model model) {
        if (curUser.getPassword().equals(newUser.getEmail())) {
            if (newUser.getNickname().equals(newUser.getPassword())) {
                curUser.setPassword(newUser.getPassword());
                userService.changeVisitorProperty(curUser.getId(), "password", newUser.getPassword());
                model.addAttribute("infoMessage", "Password successfully changed!");
                return "profilePage";
            } else {
                model.addAttribute("errMessage", "Passwords are different");
                model.addAttribute("setting", "password");
                return "changeProfileSettingsPage";
            }
        } else {
            model.addAttribute("errMessage", "Wrong password");
            model.addAttribute("setting", "password");
            return "changeProfileSettingsPage";
        }
    }
}
