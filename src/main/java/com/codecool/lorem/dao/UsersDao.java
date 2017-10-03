package com.codecool.lorem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsersDao {

    public static Integer getNextUserId() {
        Integer nextId = 0;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM users;");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                if (id > nextId) {
                    nextId = id;
                }
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return nextId + 1;
    }
}
