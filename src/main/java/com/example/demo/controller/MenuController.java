package com.example.demo.controller;


import com.example.demo.logic.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public
class MenuController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/account")
    public String account() {
        return "account";
    }
    @GetMapping("/credit")
    public String credit() {
        return "credit";
    }
    @GetMapping("/sign-in")
    public String signIn(Model model) {
        model.addAttribute("user", new User());
        return "sign-in";
    }
    @PostMapping("/sign-in")
    public String signIn(@ModelAttribute("user") User user, Model model) throws SQLException {
        model.addAttribute("id", user.getId());
        model.addAttribute("password", user.getPassword());
        if(user.signIn(user.getId(), user.getPassword())){
            return "account";
        }
        else{
            return "error";
        }
    }
    @GetMapping("/sign-un")
    public String signUn() {
        return "sign-un";
    }

}