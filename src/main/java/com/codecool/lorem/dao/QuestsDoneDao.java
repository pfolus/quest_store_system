package com.codecool.lorem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.codecool.lorem.models.DoneQuestModel;
import com.codecool.lorem.views.MainView;

public class QuestsDoneDao extends Dao<DoneQuestModel> {

    public QuestsDoneDao() { readFromDatabase();}

    public void addToDatabase(DoneQuestModel doneQuest) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            connection.setAutoCommit(false);

            Statement statement = connection.createStatement();

            String sql = String.format(
                    "INSERT INTO quests_done (id, quest_id, student_id) " +
                    "VALUES ('%d', '%d', '%d');", doneQuest.getId(),
                    doneQuest.getQuestId(), doneQuest.getStudentId());

            statement.executeUpdate(sql);
            statement.close();
            connection.commit();

        } catch (SQLException e) {

            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }

        MainView.print("Records created successfully");

    }

    private void readFromDatabase(){

        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM quests_done;");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer questId = resultSet.getInt("quest_id");
                Integer studentId = resultSet.getInt("student_id");

                this.itemsList.add(
                        new DoneQuestModel(id, questId, studentId));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public ArrayList<DoneQuestModel> getItemsByStudentId(Integer id) {
        return this.itemsList.stream()
                .filter(artifact -> artifact.getStudentId().equals(id))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
