package com.codecool.lorem.dao;

import com.codecool.lorem.models.AdminModel;

import java.sql.*;

public class AdminsDao extends Dao<AdminModel> {

    public AdminsDao() {
        loadFromDatabase();
    }

    private void loadFromDatabase(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                this.itemsList.add(new AdminModel(id, name, surname,
                        login, password, email));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
