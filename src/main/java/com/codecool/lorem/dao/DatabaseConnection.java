package com.codecool.lorem.dao;

import java.sql.*;

public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db");
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        return connection;
        }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
