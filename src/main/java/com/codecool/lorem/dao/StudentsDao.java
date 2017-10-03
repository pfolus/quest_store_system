package com.codecool.lorem.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MainView;

public class StudentsDao extends Dao<StudentModel> {

    public StudentsDao() {
        readFromDatabase();
    }

    public void addToDatabase(StudentModel student) {

        try {
            Connection connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);
            Statement statement = connection.createStatement();
            String sql = String.format(
                    "INSERT INTO users (name, surname, login, password, email, type) " +
                    "VALUES ('%s', '%s', '%s', '%s', '%s', 'student'); " +
                    "INSERT INTO students_data (user_id, score, class_id) " +
                    "VALUES ('%d', '%d', '%d');" +
                    "INSERT INTO wallets (balance, student_id) " +
                    "VALUES ('%d', '%d');", student.getName(), student.getSurname(),
                    student.getLogin(), student.getPassword(), student.getEmail(), student.getId(),
                    student.getScore(), student.getClassId(), student.getScore(), student.getId());

            statement.executeUpdate(sql);
            statement.close();

            connection.commit();

        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }

        MainView.print("Records created successfully");

    }

    private void readFromDatabase(){

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
                Integer score = resultSet.getInt("score");
                Integer classId = resultSet.getInt("class_id");

                this.itemsList.add(
                        new StudentModel(user_id, name, surname, login,
                                password, email, score, classId));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
