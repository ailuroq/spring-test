package com.example.demo.controller;


import com.example.demo.logic.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Controller
public
class GreetingController {

    @GetMapping("/greeting")
    public String greetingForm(Model model) {
        model.addAttribute("user", new User());
        return "greeting";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute("user") User user, Model model) throws SQLException {
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("mail", user.getMail());
        user.signUp(user.getFirstName(), user.getLastName(), user.getMail(), user.getPassword());
        return "result";


    }

}