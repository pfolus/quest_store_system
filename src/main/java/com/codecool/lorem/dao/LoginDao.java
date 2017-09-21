package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;

public class LoginDao {

    public ArrayList<String> login(String login, String password) {
        ArrayList<String> result = new ArrayList<>();
        ResultSet resultSet = null;
        Statement statement = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT type, id FROM users WHERE login = '" + login + "' AND password = '" + password + "';");

            if (resultSet.next()) {
                result.add(resultSet.getString("type"));
                result.add(resultSet.getString("id"));
            } else {
                result = null;
            }

            resultSet.close();
            statement.close();

            return result;
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
    }
}
