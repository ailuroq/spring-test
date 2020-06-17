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
    public String greetingSubmit(@RequestParam String firstName,
                                 @RequestParam String lastName, @RequestParam String mail,
                                 @RequestParam String password, Model model) throws SQLException {
        if(firstName.trim().length() != 0 && lastName.trim().length() != 0 && mail.trim().length() != 0 && password.trim().length() != 0) {
            User user = new User(firstName, lastName, mail, password);
            
//            user.signUp(firstName, lastName, mail, password);
            return "result";
        }
        else{
            System.out.println("at least one form is empty");
            return "result";
        }


    }

}