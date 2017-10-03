package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.DoneQuestModel;
import com.codecool.lorem.models.QuestModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MainView;

public class QuestsDoneDao extends Dao<DoneQuestModel> {

    public DoneQuestModel getDoneQuest(Integer questId, Integer studentId) {
        return this.itemsList.stream()
                             .filter(doneQuest -> doneQuest.getStudentId().equals(studentId))
                             .filter(doneQuest -> doneQuest.getQuestId().equals(questId))
                             .findFirst()
                             .orElse(null);
    }

    public void addDoneQuestToDb(QuestModel quest, Integer studentId) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String sql = String.format(
                    "INSERT INTO quests_done (times_done, quest_id, student_id) " +
                    "VALUES (0, '%d', '%d');", quest.getId(), studentId);

            statement.executeUpdate(sql);

            statement.close();
        } catch (SQLException e) {

            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }

        MainView.print("Records created successfully");

    }

    public void updateQuest(Integer id, Integer newValue) {
    try {
        Connection connection = DatabaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = String.format(
                "UPDATE quests_done SET times_done = %d WHERE id = '%d';"
                , id, newValue);

        statement.executeUpdate(sql);

        statement.close();
    } catch (SQLException e) {

        System.err.println( e.getClass().getName() + ": " + e.getMessage());
    }

    MainView.print("Records updated successfully");

    }

    public void loadQuestFromDb(Integer id) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format(
                    "SELECT * FROM quests_done WHERE id =  '%d';", id));

            while (resultSet.next()) {

                Integer timesDone = resultSet.getInt("times_done");
                Integer questId = resultSet.getInt("quest_id");
                Integer studentId = resultSet.getInt("student_id");

                this.itemsList.add(new DoneQuestModel(id, timesDone, questId, studentId));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
