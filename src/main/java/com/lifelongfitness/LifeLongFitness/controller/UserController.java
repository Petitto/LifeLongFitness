package com.lifelongfitness.LifeLongFitness.controller;
import com.lifelongfitness.LifeLongFitness.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserController {
    public User user;

    public UserController() {
        this.user = new User(UUID.randomUUID(),"Jose", "Altuve", "jose.altuve@astroforlife.com", "YankeeDaddy", "male", 165.0, "password");
    }

    @GetMapping("/users")
    public String getUsers() {
        return user.toString();
    }
}
