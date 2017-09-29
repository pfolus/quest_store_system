package com.codecool.lorem.dao;

import java.sql.*;

import com.codecool.lorem.models.DoneQuestModel;
import com.codecool.lorem.models.QuestModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MainView;

public class QuestsDoneDao extends Dao<DoneQuestModel> {

    public DoneQuestModel getDoneQuest(Integer questId, Integer studentId) {

        for (DoneQuestModel doneQuest : this.itemsList) {
            if (doneQuest.getQuestId().equals(questId) && doneQuest.getStudentId().equals(studentId)) {
                return doneQuest;
            }
        } return null;
    }

    public void addDoneQuestToDb(QuestModel quest, Integer studentId) {

        Statement statement = null;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {

            statement = connection.createStatement();
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

    Statement statement = null;

    try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {

        statement = connection.createStatement();
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

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {

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
