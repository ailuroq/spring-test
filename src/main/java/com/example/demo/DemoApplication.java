package com.example.demo;

import com.example.demo.logic.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Scanner;


@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);
        User user1 = new User();
        Scanner in = new Scanner(System.in);
//        System.out.println("Введите ваше имя");
//        this.firstName = in.nextLine();
//        System.out.println("Введите вашу фамилию");
//        this.lastName = in.nextLine();
//        System.out.println("Введите вашу почту");
//        this.mail = in.nextLine();
//        System.out.println("Введите пароль");
//        this.password = in.nextLine();
        user1.signUp("", "ovsyannikov","mail.@ru", "Kutuzov");
    }
}