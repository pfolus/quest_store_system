package com.codecool.lorem.dao;

import com.codecool.lorem.models.ClassModel;

import java.sql.*;

public class ClassesDao extends Dao<ClassModel> {

    public void loadClassesFromDb() {

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM classes");

            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                this.itemsList.add( new ClassModel(id, name));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
}
