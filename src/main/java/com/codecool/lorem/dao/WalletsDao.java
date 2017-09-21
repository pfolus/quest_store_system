package com.codecool.lorem.dao;

import com.codecool.lorem.models.WalletModel;

import java.sql.*;

public class WalletsDao extends Dao<WalletModel> {

    public WalletModel getById(Integer id) {
        for (WalletModel wallet : getItems()) {
            if (wallet.getId().equals(id)) {
                return wallet;
            }
        }

        return null;
    }

    public WalletModel getStudentWallet(Integer id) {
        WalletModel wallet = null;

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT * FROM wallets WHERE student_id = " + id + ";");

            if (resultSet.next()) {
                Integer wallet_id = resultSet.getInt("id");
                Integer balance = resultSet.getInt("balance");
                Integer studentId = resultSet.getInt("student_id");

                wallet = new WalletModel(wallet_id, balance, studentId);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }

        return wallet;
    }

    public void updateWalletBalance(Integer student_id, Integer balance) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE wallets SET balance = " + balance +
                " WHERE student_id = " + student_id + ";");

            statement.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    public void loadAllWalletsFromDb(){

        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db/quest-store.db")) {
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
 }
