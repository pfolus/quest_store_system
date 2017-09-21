package com.codecool.lorem.dao;

import com.codecool.lorem.models.AdminModel;

import java.sql.*;

public class AdminsDao extends Dao<AdminModel> {

    public AdminModel getById(Integer id) {
        for (AdminModel admin : getItems()) {
            if (admin.getId().equals(id)) {
                return admin;
            }
        }
        return null;
    }

    public void loadAdminsFromDatabase(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");

            while (resultSet.next()) {
                Integer user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                this.itemsList.add(new AdminModel(user_id, name, surname,
                        login, password, email));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public AdminModel createLoggedStudent(String id) {
        AdminModel result = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM users WHERE id = " +  id + ";");

            if (resultSet.next()) {
                Integer user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");

                result = new AdminModel(user_id, name, surname, login, password, email);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return result;
    }
}
