package com.codecool.lorem.dao;

import com.codecool.lorem.models.ClassModel;

import java.sql.*;

public class ClassesDao extends Dao<ClassModel> {

    public ClassesDao() {
        readFromDatabase();
    }

    private void readFromDatabase() {
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

    public void addToDatabase(ClassModel classModel) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(String.format("INSERT INTO classes (id, name)" + "\n" +
                            "VALUES ('%d', '%s');", classModel.getId(), classModel.getName()));

            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
