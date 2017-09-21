package com.codecool.lorem.dao;

import java.sql.*;
import java.util.Iterator;

import com.codecool.lorem.models.MentorModel;
import com.codecool.lorem.models.StudentModel;

public class MentorsDao extends Dao<MentorModel> {

    public MentorModel getById(Integer id) {
        for (MentorModel mentor : getItems()) {
            if (mentor.getId().equals(id)) {
                return mentor;
            }
        }
        return null;
    }

    public MentorModel createLoggedMentor(String id) {
        MentorModel result = null;

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM users INNER JOIN mentors_data ON users.id = mentors_data.user_id " +
                    "WHERE user_id = '%s';" , id));

            if (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer classId = resultSet.getInt("class_id");

                result = new MentorModel(userId, name, surname, login, password, email, classId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            return result;
        }

        return result;
    }

}
