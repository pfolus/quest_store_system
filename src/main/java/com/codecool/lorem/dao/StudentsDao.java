package com.codecool.lorem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MainView;

public class StudentsDao extends Dao<StudentModel> {

    public StudentModel getById(Integer id) {
        for (StudentModel student : getItems()) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public StudentModel createLoggedStudent(String id) {
        StudentModel result = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM users INNER JOIN students_data ON users.id = students_data.user_id " +
                         "WHERE user_id = " + id +";");

            if (resultSet.next()) {
                Integer user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer levelId = resultSet.getInt("level_id");
                Integer score = resultSet.getInt("score");
                Integer classId = resultSet.getInt("class_id");

                result = new StudentModel(user_id, name, surname, login, password, email, levelId, score, classId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return result;
    }

    public void addStudentToDatabase(String name, String surname, String login,
                                            String password, String email, Integer classId) {

        Statement statement = null;
        Integer startingBalance = 1000;

        try {
            Connection connection = DatabaseConnection.getConnection();
            statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO users (name, surname, login, password, email, type) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s', 'student'); " +
                    "INSERT INTO students_data (user_id, level_id, score, class_id) " +
                    "VALUES (last_insert_rowid(), 1, 0, '%d');" +
                    "INSERT INTO wallets (balance, student_id) " +
                    "VALUES (%d, last_insert_rowid());", name, surname, login, password, email, classId, startingBalance);


            statement.executeUpdate(sql);

            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }

        MainView.print("Records created successfully");

    }

    public void loadStudentsFromDb(){

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM users INNER JOIN students_data ON users.id = students_data.user_id;");

            while (resultSet.next()) {
                Integer user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer levelId = resultSet.getInt("level_id");
                Integer score = resultSet.getInt("score");
                Integer classId = resultSet.getInt("class_id");

                this.itemsList.add(
                        new StudentModel(user_id, name, surname, login,
                                password, email, levelId, score, classId));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void loadStudentFromDbByLogin(String login){

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM users INNER JOIN students_data ON users.id = students_data.user_id;" +
                    "WHERE login =  '%s';", login));

            while (resultSet.next()) {

                Integer user_id = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer levelId = resultSet.getInt("level_id");
                Integer score = resultSet.getInt("score");
                Integer classId = resultSet.getInt("class_id");

                this.itemsList.add(
                        new StudentModel(user_id, name, surname, login,
                                password, email, levelId, score, classId));
            }

            resultSet.close();
            statement.close();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
