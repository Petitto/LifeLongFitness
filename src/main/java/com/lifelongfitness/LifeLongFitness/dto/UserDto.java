package com.lifelongfitness.LifeLongFitness.dto;

import com.lifelongfitness.LifeLongFitness.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDto {
    public static User UserDtoOut(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getString("email_address"),
                resultSet.getString("user_gender"),
                resultSet.getDouble("user_weight"),
                resultSet.getString("user_password"));
    }
    public static void UserDtoIn(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, user.getFirstName());
        preparedStatement.setString(2, user.getLastName());
        preparedStatement.setString(3, user.getEmail());
        preparedStatement.setString(4, user.getGender());
        preparedStatement.setDouble(5, user.getWeight());
        preparedStatement.setString(6, user.getPassword());
    }
}
