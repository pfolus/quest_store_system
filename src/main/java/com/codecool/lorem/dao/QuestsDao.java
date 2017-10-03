package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.QuestModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MainView;

public class QuestsDao extends Dao<QuestModel> {

    public QuestsDao() {
        readFromDatabase();
    }

    public void addToDatabase(QuestModel quest) {

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String sql = String.format(
                    "INSERT INTO quests (name, description, quest_category_id, prize) " +
                    "VALUES ('%s', '%s', '%d', '%d');" , quest.getName(), quest.getDescription(),
                    quest.getCategoryId(), quest.getPrize());

            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        MainView.print("Records created successfully");
    }

    private void readFromDatabase() {
        try {
            Connection connection = DatabaseConnection.getConnection();
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
