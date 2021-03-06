package com.lifelongfitness.LifeLongFitness.implementation;

import com.lifelongfitness.LifeLongFitness.dto.UserDto;
import com.lifelongfitness.LifeLongFitness.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserRepository {
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    private Connection db;

    //todo:figure out url being null
    public UserRepository() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        try{
            this.url = "jdbc:postgresql://localhost:5432/LifeLongFitnessDB";
            this.username = "postgres";
            this.password = "Password123";
            db = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public List<User> getUsers() throws SQLException {
        List<User> userList = new ArrayList<>();
        String sql = "select * from public.\"UserTable\";";
        PreparedStatement sqlStatement = db.prepareStatement(sql);
        ResultSet resultSet = sqlStatement.executeQuery();
        while(resultSet.next()){
            userList.add(UserDto.UserDtoOut(resultSet));
        }
        return userList;
    }

    public User getUser(String username) throws SQLException {
        String sql = "SELECT * from public.\"UserTable\"" +
                "where user_username = '" + username + "'";
        PreparedStatement preparedStatement = db.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        if(resultSet.next()) {
            return UserDto.UserDtoOut(resultSet);
        }
       return null;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO public.\"UserTable\"(" +
                "user_uuid, user_firstname, user_lastname, user_email, user_username, user_gender, user_weight, user_password) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement preparedStatement = db.prepareStatement(sql);
        UserDto.UserDtoIn(user, preparedStatement);
        int row = preparedStatement.executeUpdate();
        // rows affected
        System.out.println(row); //1
    }

    public int updateUser(User user) throws SQLException {
        String sql = "UPDATE public.\"UserTable\"" +
                "SET user_uuid=?," +
                " user_firstname=?," +
                " user_lastname=?," +
                " user_email=?," +
                " user_username=?," +
                " user_gender=?," +
                " user_weight=?," +
                " user_password=?" +
                "where user_username = ?";
        PreparedStatement preparedStatement = db.prepareStatement(sql);
        UserDto.UserDtoIn(user, preparedStatement);
        preparedStatement.setString(9, user.getUserName());
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }

    public int deleteUser(String username) throws SQLException {
        String sql = "DELETE FROM public.\"UserTable\"" +
                "WHERE user_username = ?";
        PreparedStatement preparedStatement = db.prepareStatement(sql);
        preparedStatement.setString(1, username);
        int executeUpdate = preparedStatement.executeUpdate();
        return executeUpdate;
    }
}
