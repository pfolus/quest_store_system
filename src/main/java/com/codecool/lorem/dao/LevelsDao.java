package com.codecool.lorem.dao;

import java.sql.Connection;
import static java.util.Comparator.comparing;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;

import com.codecool.lorem.models.LevelModel;

public class LevelsDao extends Dao<LevelModel> {

    public LevelsDao() {
        readFromDatabase();
    }

    private void readFromDatabase() {

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM levels;");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Integer requiredScore = resultSet.getInt("required_score");

                LevelModel level = new LevelModel(id, requiredScore, name);
                this.itemsList.add(level);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public String checkLevel(Integer score) {
        String levelName = "";

        Collections.sort(this.itemsList, comparing(LevelModel::getRequiredScore));

        for (LevelModel level : this.itemsList) {
            if (score >= level.getRequiredScore()) {
                levelName = level.getName();
            }
        }
        return levelName;
    }
}
