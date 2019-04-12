package com.pokorili.musicOn.controller;

import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.service.ConnectionService;
import com.pokorili.musicOn.service.ParametrService;
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
    @Autowired
    ParametrService parametrService;
    @Autowired
    ConnectionService connectionService;


    @ModelAttribute("newUser")
    public Users createNewVisitor() {
        return new Users();
    }

    @GetMapping("/profile")
    // add model to put data to page of last parametrs
    public String getProfilePage(Model model, @SessionAttribute("user") Users users) {
        model.addAttribute("parametrs", parametrService.getLast(users.getId()));

        return "profilePage";
    }

    @GetMapping("/changeEmail")
    public String getChangeEmailPage(Model model) {
        model.addAttribute("setting", "email");
        return "changeProfileSettingsPage";
    }

    @PostMapping("/changeEmail")
    public String changeEmail(@SessionAttribute("user")Users curUser, @ModelAttribute("newUser")Users newUser, Model model) {
        Users checkVisitor = userService.getUserByEmail(newUser.getEmail());
        if (checkVisitor != null) {
            model.addAttribute("errMessage", "This email is already registered");
            model.addAttribute("setting", "email");
            return "changeProfileSettingsPage";
        } else {
            curUser.setEmail(newUser.getEmail());
            userService.changeUserProperty(curUser.getId(), "email", newUser.getEmail());
            model.addAttribute("infoMessage", "Email successfully changed!");
            connectionService.sendEmail(curUser.getEmail(), "Email change" ,"This email was chosen as a profile email of " + curUser.getLogin() + " on Ubermensch");

            return "profilePage";
        }
    }

    @GetMapping("/changeLogin")
    public String getChangeLoginPage(Model model) {
        model.addAttribute("setting", "login");
        return "changeProfileSettingsPage";
    }

    @PostMapping("/changeLogin")
    public String changeLogin(@SessionAttribute("user")Users curUser, @ModelAttribute("newUser")Users newUser, Model model) {
        Users checkVisitor = userService.getUserByLogin(newUser.getLogin());
        if (checkVisitor != null) {
            model.addAttribute("errMessage", "This login is already registered");
            model.addAttribute("setting", "login");
            return "changeProfileSettingsPage";
        } else {
            curUser.setLogin(newUser.getLogin());
            userService.changeUserProperty(curUser.getId(), "login", newUser.getLogin());
            model.addAttribute("infoMessage", "Login successfully changed!");
            connectionService.sendEmail(curUser.getEmail(), "Nickname Change" ,"Your nickname was changed!\nYour new nickname is: " + curUser.getLogin());

            return "profilePage";
        }
    }

    @GetMapping("/changePassword")
    public String getChangePasswordPage(Model model) {
        model.addAttribute("setting", "password");
        return "changeProfileSettingsPage";
    }

    @PostMapping("/changePassword")
    public String changePassword(@SessionAttribute("user") Users curUser, @ModelAttribute("newUser") Users newUser, Model model) {
        if (curUser.getPassword().equals(newUser.getEmail())) {
            if (newUser.getLogin().equals(newUser.getPassword())) {
                curUser.setPassword(newUser.getPassword());
                userService.changeUserProperty(curUser.getId(), "password", newUser.getPassword());
                connectionService.sendEmail(curUser.getEmail(), "Password change" ,"Your password was changed!\nYour new password is: " + curUser.getPassword());
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
