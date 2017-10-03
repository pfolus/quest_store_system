package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.QuestCategoryModel;

public class QuestCategoriesDao extends Dao<QuestCategoryModel> {

    public QuestCategoriesDao() {
        readFromDatabase();
    }

    private void readFromDatabase(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quest_categories ");

            while (resultSet.next()) {

                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");

                this.itemsList.add(new QuestCategoryModel(id, name));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
