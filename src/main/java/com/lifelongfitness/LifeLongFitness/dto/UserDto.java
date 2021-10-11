package com.lifelongfitness.LifeLongFitness.dto;

import com.lifelongfitness.LifeLongFitness.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class UserDto {
    public static User UserDtoOut(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getObject("user_uuid", UUID.class),
                resultSet.getString("user_firstname"),
                resultSet.getString("user_lastname"),
                resultSet.getString("user_email"),
                resultSet.getString("user_username"),
                resultSet.getString("user_gender"),
                resultSet.getDouble("user_weight"),
                resultSet.getString("user_password"));
    }
    public static void UserDtoIn(User user, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setObject(1, user.getUuid(), java.sql.Types.OTHER);
        preparedStatement.setString(2, user.getFirstName());
        preparedStatement.setString(3, user.getLastName());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getUserName());
        preparedStatement.setString(6, user.getGender());
        preparedStatement.setDouble(7, user.getWeight());
        preparedStatement.setString(8, user.getPassword());
    }
}
