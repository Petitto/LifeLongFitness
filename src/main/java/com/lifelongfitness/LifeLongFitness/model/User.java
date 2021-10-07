package com.lifelongfitness.LifeLongFitness.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
    //fixme: Set up proper user in DB
//    private UUID uuid;
    private String firstName;
    private String lastName;
    private String email;
//    private String userName;
    private String gender;
    private double weight;
    private String password;
}
