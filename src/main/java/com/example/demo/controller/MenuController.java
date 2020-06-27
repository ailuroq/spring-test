package com.example.demo.controller;


import com.example.demo.logic.user.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.SQLException;

@Controller
public
class MenuController {
    @GetMapping("/home")
    public String home(){
        return "home";
    }
    @GetMapping("/account")
    public String account(@ModelAttribute("id") User user, Model model, RedirectAttributes redirectAttrs) throws SQLException {
        model.addAttribute("user", new User());
        model.addAttribute("firstName", user.getFirstNameFromDatabase(user.getId()));
        model.addAttribute("lastName", user.getLastNameFromDatabase(user.getId()));
        model.addAttribute("mail", user.getMailFromDatabase(user.getId()));
        model.addAttribute("id", user.getId());
        model.addAttribute("password", user.getPasswordFromDatabase(user.getId()));
        redirectAttrs.addAttribute("id", user.getId());

        return "account";
    }
    @PutMapping("/account")
    public String accountPost(@ModelAttribute("user") User user, Model model) throws SQLException {
        model.addAttribute("payment", user.getPayment());
        user.payIn(user.getId(), user.getPayment());
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
    public String signIn(@ModelAttribute("user") User user, Model model, RedirectAttributes redirectAttrs) throws SQLException {
        model.addAttribute("firstName", user.getFirstNameFromDatabase(user.getId()));
        model.addAttribute("lastName", user.getLastNameFromDatabase(user.getId()));
        model.addAttribute("mail", user.getMailFromDatabase(user.getId()));
        model.addAttribute("id", user.getId());
        model.addAttribute("password", user.getPassword());
        redirectAttrs.addAttribute("id", user.getId());
        if(user.signIn(user.getId(), user.getPassword())){
            return "redirect:/account";
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