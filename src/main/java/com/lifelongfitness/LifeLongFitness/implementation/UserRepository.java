package com.lifelongfitness.LifeLongFitness.implementation;

import com.lifelongfitness.LifeLongFitness.dto.UserDto;
import com.lifelongfitness.LifeLongFitness.model.User;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@ConfigurationProperties(prefix="spring.datasource")
public class UserRepository {
    private String url;
    private String username;
    private String password;
    private Connection db;

    //todo:figure out url being null
    public UserRepository() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try{
            System.out.println(url);
            db = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    public List<User> getUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "select * from public.'userstable';";
        PreparedStatement sqlStatement = db.prepareStatement(sql);
        ResultSet resultSet = sqlStatement.executeQuery();
        while(resultSet.next()){
            userList.add(UserDto.UserDtoOut(resultSet));
        }
        return userList;
    }

}
