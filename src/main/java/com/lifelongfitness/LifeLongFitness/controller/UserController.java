package com.lifelongfitness.LifeLongFitness.controller;
import com.lifelongfitness.LifeLongFitness.implementation.UserRepository;
import com.lifelongfitness.LifeLongFitness.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {
    public UserRepository userRepository;

    public UserController() throws SQLException, ClassNotFoundException {
        userRepository = new UserRepository();
    }

    @GetMapping("/users")
    public String getUsers() throws SQLException {
        String response = "";
        List<User> userList = userRepository.getUsers();
        for(User user : userList) {
            response += user.toString() + "\n";
        }
        return response;
    }
}
