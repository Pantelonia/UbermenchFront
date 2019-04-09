package com.pokorili.musicOn.controller;


import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.service.UserService;
import org.apache.catalina.User;
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
    UserService userService;

    @ModelAttribute("user")
    public Users createUser() {
        return new Users();
    }

    @ModelAttribute("newUser")
    public Users createNewUser() {
        return new Users();
    }

    @GetMapping("/")
    public String getMainPage(Model model) {
        return "mainPage";
    }


    @GetMapping("/login")
    public String getLoginPage() {
        return "loginPage";
    }

    @PostMapping("/login")
    public String checkLogin(@ModelAttribute("user") Users user, Model model) {
        Users searchUser = userService.getUserByLogin(user.getLogin());

        if (searchUser != null) {

            if (user.getPassword().equals(searchUser.getPassword())) {
                user.setEmail(searchUser.getEmail());
                user.setId(searchUser.getId());
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
    public String logout(@SessionAttribute("user") Users user) {
        Users defaultUser = createUser();
        user.setLogin(defaultUser.getLogin());
        user.setEmail(defaultUser.getEmail());
        user.setPassword(defaultUser.getPassword());
        return "mainPage";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        return "registerPage";
    }

    @PostMapping("/register")

    //madel atttribute take users from form
    public String registerNewUser(@ModelAttribute("newUser") Users newUser, @SessionAttribute("user") Users user, Model model) {
        Users searchEmailVisitor = userService.getUserByEmail(newUser.getEmail());
        Users searchLoginVisitor = userService.getUserByLogin(newUser.getLogin());
        if (searchEmailVisitor == null && searchLoginVisitor == null) {
            newUser = userService.addVisitor(newUser);
            user.setId(newUser.getId());
            user.setLogin(newUser.getLogin());
            user.setEmail(newUser.getEmail());
            user.setPassword(newUser.getPassword());
            return "mainPage";
        } else {
            if (searchEmailVisitor != null) {
                model.addAttribute("errMessage", "This email is already registered");
                return "registerPage";
            } else {
                model.addAttribute("errMessage", "This nickname is already registered");
                return "registerPage";
            }
        }
    }


}
