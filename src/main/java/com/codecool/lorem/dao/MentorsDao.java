package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.MentorModel;

public class MentorsDao extends Dao<MentorModel> {

    public MentorsDao() {
        loadFromDatabase();
    }

    private void loadFromDatabase(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM users INNER JOIN mentors_data ON users.id = mentors_data.user_id;"));

            while (resultSet.next()) {
                Integer userId = resultSet.getInt("user_id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                Integer classId = resultSet.getInt("class_id");

                this.itemsList.add(new MentorModel(userId, name, surname, login, password, email, classId));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void addToDatabase(MentorModel mentor) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            statement.executeUpdate(String.format("INSERT INTO users (id, name, surname, login, password, email, type)" + "\n" +
                            "VALUES ('%d', '%s', '%s', '%s', '%s', '%s', 'mentor');" + "\n" +
                            "INSERT INTO mentors_data (user_id, class_id) VALUES ('%d', '%d');",
                    mentor.getId(), mentor.getName(), mentor.getSurname(),
                    mentor.getLogin(), mentor.getPassword(), mentor.getEmail(),
                    mentor.getId(), mentor.getClassId()));

            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
