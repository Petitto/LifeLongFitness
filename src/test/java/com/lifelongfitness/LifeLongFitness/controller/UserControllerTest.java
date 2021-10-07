package com.lifelongfitness.LifeLongFitness.controller;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.sql.SQLException;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mvc;
    private UUID testId;
    private UserController userController;
    @BeforeEach
    public void setUp() throws SQLException, ClassNotFoundException {
        userController = new UserController();
    }
    //todo: re-write test
    @Test
    public void getUsers_HappyPath() throws Exception {
        //given a get request to /users path
        //when the request is sent
        mvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                //expect a OK status
                .andExpect(status().isOk());
        //when function call to getUsers
        String response = userController.getUsers();
        //expect the response to equal jose altuve stuff
//        assertThat(response, equalTo("User(uuid="+ testId.toString() +
//                                        ", firstName=Jose, lastName=Altuve, " +
//                                        "email=jose.altuve@astroforlife.com, userName=YankeeDaddy, " +
//                                        "gender=male, weight=165.0, password=password)"));
    }
}
