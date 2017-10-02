package com.codecool.lorem.dao;

import com.codecool.lorem.models.PendingUserModel;

import java.sql.*;
import java.util.ArrayList;

public class LoginDao {

    public PendingUserModel login(String login, String password) {
        PendingUserModel pendingUser = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT type, id FROM users WHERE login = '" + login + "' AND password = '" + password + "';");

            if (resultSet.next()) {
                pendingUser = new PendingUserModel(resultSet.getString("id"),
                        resultSet.getString("type"));
            } else {
                throw new SQLException();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("\nWrong data! Couldn't login.");
        }

        return pendingUser;
    }
}
