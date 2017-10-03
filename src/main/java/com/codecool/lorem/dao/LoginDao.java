package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.PendingUser;

public class LoginDao {

    public PendingUser login(String login, String password) {
        PendingUser pendingUser = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT type, id FROM users WHERE login = '" + login + "' AND password = '" + password + "';");

            if (resultSet.next()) {
                pendingUser = new PendingUser(resultSet.getInt("id"),
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
