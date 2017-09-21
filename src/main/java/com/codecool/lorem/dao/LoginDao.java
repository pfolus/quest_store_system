package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;

public class LoginDao {

    public ArrayList<String> login(String login, String password) {
        ArrayList<String> result = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT type, id FROM users WHERE login = '" + login + "' AND password = '" + password + "';");

            if (resultSet.next()) {
                result = new ArrayList<>();

                result.add(resultSet.getString("type"));
                result.add(resultSet.getString("id"));
            } else {
                throw new SQLException();
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("\nWrong data! Couldn't login.");
        }

        return result;
    }
}
