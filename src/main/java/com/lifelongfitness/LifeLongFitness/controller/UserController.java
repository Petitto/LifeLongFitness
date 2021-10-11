package com.lifelongfitness.LifeLongFitness.controller;
import com.lifelongfitness.LifeLongFitness.implementation.UserRepository;
import com.lifelongfitness.LifeLongFitness.model.User;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController {
    public UserRepository userRepository;

    public UserController() throws SQLException, ClassNotFoundException {
        userRepository = new UserRepository();
    }

    @GetMapping("/userList")
    public List<User> getUsers() throws SQLException {
        return userRepository.getUsers();
    }

    @GetMapping("/user/{username}")
    @ResponseBody
    public User getUser(@PathVariable("username") String username) throws SQLException {
        System.out.println(username);
        return userRepository.getUser(username);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) throws SQLException {
        System.out.println(user.toString());
        user.setUuid(UUID.randomUUID());
        userRepository.addUser(user);
    }

    @PutMapping("/user")
    public int updateUser(@RequestBody User user) throws SQLException {
        return userRepository.updateUser(user);
    }

    @DeleteMapping("/user/{username}")
    public int deleteUser(@PathVariable("username") String username) throws SQLException {
        return userRepository.deleteUser(username);
    }
}
