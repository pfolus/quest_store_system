package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.StudentModel;

public class StudentsDao extends Dao<StudentModel> {

    public StudentModel get(Integer id) {
        for (StudentModel student : getItems()) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    public StudentModel createLoggedStudent(String id) {
        StudentModel result = null;
        ResultSet resultSet = null;
        Statement statement = null;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/db/quest-store.db")) {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(
                    "SELECT * FROM users INNER JOIN students_data ON users.id = students_data.user_id");

            if (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer levelId = resultSet.getInt("level_id");
                Integer score = resultSet.getInt("score");
                Integer classId = resultSet.getInt("class_id");

                result = new StudentModel(id, name, surname, login, password, email, levelId, score, classId);
            }

            resultSet.close();
            statement.close();

            return result;
        } catch (SQLException e) {
            return result;
        }
    }
}
