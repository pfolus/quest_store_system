package com.codecool.lorem.dao;

import com.codecool.lorem.models.BoughtArtifactModel;
import com.codecool.lorem.models.GroupTransactionModel;
import com.codecool.lorem.models.StudentModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GroupTransactionsDao extends Dao<GroupTransactionModel> {

    public GroupTransactionsDao() {
        readFromDatabase();
    }

    public void readFromDatabase() {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            stmt = c.createStatement();
            rs = stmt.executeQuery("SELECT * FROM group_transactions;");

            while (rs.next()) {

                Integer id = rs.getInt("id");
                Integer artifactId = rs.getInt("artifact_id");
                Integer studentsAccepted = rs.getInt("students_accepted");
                Integer requiredAcceptances = rs.getInt("required_acceptances");
                Integer studentId = rs.getInt("student_id");
                Integer price = rs.getInt("price");
                String status = rs.getString("status");

                GroupTransactionModel transaction = new GroupTransactionModel(id, artifactId, studentsAccepted, requiredAcceptances, studentId, price, status);

                this.itemsList.add(transaction);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

//    public ArrayList<BoughtArtifactModel> getItemsByStudentId(Integer id) {
//        ArrayList<BoughtArtifactModel> studentsBoughtArtifacts = new ArrayList<>();
//
//        for (BoughtArtifactModel artifact:this.itemsList) {
//            if (artifact.getStudentId().equals(id)) {
//                studentsBoughtArtifacts.add(artifact);
//            }
//        }
//        return studentsBoughtArtifacts;
//    }
//
    public void addTransactionToDatabase(GroupTransactionModel transaction) {
        Statement stmt = null;

        Integer id = transaction.getId();
        Integer artifactId = transaction.getArtifactId();
        Integer studentsAccepted = transaction.getStudentsAccepted();
        Integer requiredAcceptances = transaction.getRequiredAcceptances();
        Integer studentId = transaction.getStudentId();
        Integer price = transaction.getPrice();
        String status = transaction.getStatus();


        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate("INSERT INTO group_transactions (id, artifact_id, students_accepted, required_acceptances, student_id, price, status)"
                    + " VALUES (" + id + ", " + artifactId + ", " + studentsAccepted + ", " + requiredAcceptances + ", " + studentId + ", " + price + ",'" + status + "');");

            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public ArrayList<GroupTransactionModel> getTransactionsByStudentId(Integer id) {

        ArrayList<GroupTransactionModel> studentTransactions = new ArrayList<>();

        for (GroupTransactionModel transaction : this.itemsList) {
            if (transaction.getStudentId().equals(id) && transaction.getStatus().equals("Not Marked")) {
                studentTransactions.add((transaction));
            }
        }
        return studentTransactions;
    }

    public void removeTransaction(GroupTransactionModel transaction) {
        Integer id = transaction.getId();
        Statement stmt = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate(String.format("DELETE FROM group_transactions WHERE id = " + id + ";"));

            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void markTransaction(GroupTransactionModel transaction, StudentModel student) {

        Integer id = transaction.getId();
        Integer studentId = student.getId();
        Integer acceptances = transaction.getStudentsAccepted();
        Statement stmt = null;
//
        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate(String.format("UPDATE group_transactions SET students_accepted = " + acceptances + " WHERE id = " + id + ";"));
            stmt.close();
            c.commit();
            stmt.executeUpdate(String.format("UPDATE group_transactions SET status = 'Marked' WHERE student_id = " + studentId + ";"));


            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    //
//    public void deleteArtifactFromDb(Integer id) {
//        Statement stmt = null;
//
//        try {
//            Connection c = DatabaseConnection.getConnection();
//            c.setAutoCommit(false);
//
//            stmt = c.createStatement();
//
//            stmt.executeUpdate(String.format(
//                    "DELETE FROM bought_artifacts WHERE id = %d;", id));
//
//            stmt.close();
//            c.commit();
//        } catch ( Exception e ) {
//            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//        }
//    }
}
