package com.pokorili.musicOn.controller;


import com.pokorili.musicOn.entity.Users;
import com.pokorili.musicOn.service.ConnectionService;
import com.pokorili.musicOn.service.CryptService;
import com.pokorili.musicOn.service.UserService;
import org.apache.catalina.User;
import org.apache.commons.lang3.RandomStringUtils;
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

    @Autowired
    ConnectionService connectionService;
    @Autowired
    CryptService cryptService;

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
//            user.setId(newUser.getId());
//            user.setLogin(newUser.getLogin());
//            user.setEmail(newUser.getEmail());
//            user.setPassword(newUser.getPassword());
            connectionService.sendEmail(newUser.getEmail(), "Registration on MusicOn", "Your email was used to register on MusicOn" +
                    "\nTo confirm registration, please, follow this link:" + "http://localhost:4000/approveRegistration?token=" + cryptService.getAuthToken(newUser.getEmail()));

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

    @GetMapping(value = "/approveRegistration", params = {"token"})
    public String approveRegistration(@RequestParam String token, Model model) {
        Users user = userService.getUserByEmail(cryptService.decodeToken(token));
        if (user != null) {
            userService.changeUserProperty(user.getId(), "status", "User");
            connectionService.sendEmail(user.getEmail(), "Successful Registration", "You've successfully registered on MusicOn!" +
                    "\nYour nickname: " + user.getLogin() + "\nYour password: " + user.getPassword() + "\nEnjoy!");
            model.addAttribute("infoMessage", "You've successfully registered!");
        }
        model.addAttribute("user", createUser() );
        return "loginPage";
    }

    @GetMapping("/resetPassword")
    public String getResetPasswordPage(){
        return "resetPasswordPage";
    }

    @PostMapping("/resetPassword")
    public String forgotPassword(@ModelAttribute("newUser") Users newUser, Model model){
        Users checkVisitor = userService.getUserByEmail(newUser.getEmail());
        if (checkVisitor == null) {
            model.addAttribute("errMessage", "This email isn't registered");
            return "resetPasswordPage";
        } else {
//            String message = userService.isUserValid(checkVisitor);

                String generatedPass = RandomStringUtils.random(8, true, true);
                userService.changeUserProperty(checkVisitor.getId(), "password", generatedPass);
                model.addAttribute("infoMessage", "Email successfully changed!");
                connectionService.sendEmail(newUser.getEmail(), "Password reset",
                        "Your password was reseted!\nYour new password is: " + generatedPass);
                model.addAttribute("infoMessage", "Password was reseted. Please check your email.");
                return "loginPage";


        }
    }


}
