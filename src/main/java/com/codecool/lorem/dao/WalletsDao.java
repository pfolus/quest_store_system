package com.codecool.lorem.dao;

import com.codecool.lorem.models.WalletModel;
import com.codecool.lorem.views.MainView;

import java.sql.*;

public class WalletsDao extends Dao<WalletModel> {

    public WalletsDao() {
        readFromDatabase();
    }

    public WalletModel getStudentWallet(Integer studentId) {
        return getItems().stream()
                         .filter(item -> item.getStudentId().equals(studentId))
                         .findFirst()
                         .orElse(null);
    }

    public void updateWalletBalance(Integer student_id, Integer balance) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE wallets SET balance = " + balance +
                " WHERE student_id = " + student_id + ";");

            statement.close();
            connection.commit();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }


    private void readFromDatabase(){
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM wallets;");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                Integer balance = resultSet.getInt("balance");
                Integer studentId = resultSet.getInt("student_id");

                this.itemsList.add(
                        new WalletModel(id, balance, studentId));
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void addToDatabase(WalletModel wallet) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            Statement statement = connection.createStatement();

            String sql = String.format(
                    "INSERT INTO wallets (id, balance, student_id) " +
                            "VALUES ('%d', '%d', '%d');", wallet.getId(),
                    wallet.getBalance(), wallet.getStudentId());

            statement.executeUpdate(sql);

            statement.close();
        } catch (SQLException e) {

            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }

        MainView.print("Records created successfully");

    }
 }
