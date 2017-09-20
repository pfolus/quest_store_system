package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.QuestModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MainView;

public class QuestsDao extends Dao<QuestModel> {

    public QuestModel get(Integer id) {
        for (QuestModel quest : getItems()) {
            if (quest.getId().equals(id)) {
                return quest;
            }
        }
        return null;
    }

    public void addQuestToDatabase(String name, Integer categoryId, String description, Integer prize) {
        Statement statement = null;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/db/quest-store.db")) {

            statement = connection.createStatement();

            String sql = String.format(
                    "INSERT INTO quests (name, description, quest_category_id, prize) " +
                    "VALUES ('%s', '%s', '%d', '%d');" , name, description, categoryId, prize);

            statement.executeUpdate(sql);

            statement.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        MainView.print("Records created successfully");

    }

    public void loadQuestsFromDatabase() {
        //call that shit in the constructor

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/db/quest-store.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM quests");

        while (resultSet.next()) {
            Integer questId = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String description = resultSet.getString("description");
            Integer questCategoryId = resultSet.getInt("quest_category_id");
            Integer prize = resultSet.getInt("prize");

            this.itemsList.add( new QuestModel(questId, name, questCategoryId, description, prize));
        }

        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        System.exit(0);
    }
    }

}
