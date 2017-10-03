package com.codecool.lorem.dao;

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
                Integer studentId = rs.getInt("student_id");
                Integer price = rs.getInt("price");
                String status = rs.getString("status");

                GroupTransactionModel transaction = new GroupTransactionModel(id, artifactId, studentId, price, status);

                this.itemsList.add(transaction);
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public void addTransactionToDatabase(GroupTransactionModel transaction) {
        Statement stmt = null;

        Integer id = transaction.getId();
        Integer artifactId = transaction.getArtifactId();
        Integer studentId = transaction.getStudentId();
        Integer price = transaction.getPrice();
        String status = transaction.getStatus();

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate("INSERT INTO group_transactions (id, artifact_id, student_id, price, status)"
                    + " VALUES (" + id + ", " + artifactId + ", " + studentId + ", " + price + ",'" + status + "');");

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

        Integer studentId = student.getId();
        Statement stmt = null;

        try {
            Connection c = DatabaseConnection.getConnection();
            c.setAutoCommit(false);

            stmt = c.createStatement();

            stmt.executeUpdate(String.format("UPDATE group_transactions SET status = 'Marked' WHERE student_id = " + studentId + ";"));


            stmt.close();
            c.commit();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public boolean isTransactionAcceptedByAll(Integer transactionId) {

        for (GroupTransactionModel transaction:this.itemsList) {
            if (transaction.getId().equals(transactionId)) {
                if (transaction.getStatus().equals("Not Marked")) {
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<StudentModel> getTransactionParticipants(Integer transactionId) {
        StudentsDao students = new StudentsDao();
        ArrayList<StudentModel> buyers = new ArrayList<>();

        for (GroupTransactionModel transaction:this.itemsList) {
            if (transaction.getId().equals(transactionId)) {
                buyers.add(students.getById(transaction.getStudentId()));
            }
        }
        return buyers;
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
