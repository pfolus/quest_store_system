package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.QuestCategoryModel;

public class QuestCategoriesDao extends Dao<QuestCategoryModel> {

    public QuestCategoryModel get(Integer id) {

        for (QuestCategoryModel questCategory : getItems()) {
            if (questCategory.getId().equals(id)) {

                return questCategory;
            }
        }
        return null;
    }

    public void loadQuestCategoriesFromDb(){

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {

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
