package com.codecool.lorem.controllers;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.GroupTransactionModel;
import com.codecool.lorem.views.StoreView;
import com.codecool.lorem.models.ArtifactModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.models.WalletModel;


public class StoreController {

    public static void runController(StudentModel student, WalletModel wallet, WalletsDao wallets) {

        int choice = -1;
        final int EXIT = 0;

        while (choice != EXIT) {
            StoreView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                buyArtifact(student, wallet, wallets);
            } else if (choice == 2) {
                buyArtifactWithTeammates(student, wallet);
            } else if (choice == 3) {
                managePendingTransactions(student, wallet, wallets);
            }
        }
    }

    private static void managePendingTransactions(StudentModel student, WalletModel wallet, WalletsDao wallets) {
        GroupTransactionsDao transactions = new GroupTransactionsDao();
        Integer transactionId = chooseTransactionId(student, transactions);

        if (!transactionId.equals(0)) {
            GroupTransactionModel transaction = transactions.getById(transactionId);
            Integer choice = StoreView.acceptOrDeclineTransaction(transaction);

            if (choice.equals(0)) {
                transactions.removeTransaction(transaction);

            } else if (choice.equals(1)) {
                acceptTransaction(wallet, transaction, transactions, student, wallets);
            }
        }
    }

    private static void acceptTransaction(WalletModel wallet, GroupTransactionModel transaction, GroupTransactionsDao transactions, StudentModel student, WalletsDao wallets) {
        if (hasEnoughCoins(wallet, transaction.getPrice())) {
            transaction.setStatus();
            transactions.markTransaction(transaction, student);
            if (transactions.isTransactionAcceptedByAll(transaction.getId())) {
                ArrayList<StudentModel> buyers = getBuyers(transaction, transactions);
                if (buyersHaveMoney(transaction, wallets, buyers)) {
                    addArtifactToBuyers(transaction, buyers, wallets);
                } else {
                    System.out.println("One or more of participants do not have enough money, transaction deleted.");
                }
            }
            transactions.removeTransaction(transaction);
        } else {
            System.out.println("You don't have enough money.");
        }
    }

    private static Integer chooseTransactionId(StudentModel student, GroupTransactionsDao transactions) {
        StoreView.showTransactions(transactions.getTransactionsByStudentId(student.getId()));
        Integer transactionId = StoreView.chooseTransactionId();

        return transactionId;
    }

    private static Boolean buyersHaveMoney(GroupTransactionModel transaction, WalletsDao wallets, ArrayList<StudentModel> buyers) {
        for (StudentModel s:buyers) {
            if (!(hasEnoughCoins(wallets.getStudentWallet(s.getId()), transaction.getPrice()))) {
                return false;
            }
        }
        return true;
    }

    private static void addArtifactToBuyers(GroupTransactionModel transaction, ArrayList<StudentModel> buyers, WalletsDao wallets) {

        addBuyersToDatabase(buyers, transaction);
        for (StudentModel s:buyers) {
            reduceWalletBalance(transaction.getPrice(), s, wallets);
        }
    }

    private static ArrayList<StudentModel> getBuyers(GroupTransactionModel transaction, GroupTransactionsDao transactions) {
        return transactions.getTransactionParticipants(transaction.getId());
    }

    private static void addBuyersToDatabase(ArrayList<StudentModel> buyers, GroupTransactionModel transaction) {
        ArtifactsBoughtDao boughtArtifacts = new ArtifactsBoughtDao();
        for (StudentModel s : buyers) {
            boughtArtifacts.addToDatabase(transaction.getArtifactId(), s.getId());
        }
    }


    private static void buyArtifact(StudentModel student, WalletModel wallet, WalletsDao wallets) {


        ArtifactsDao artifacts = getArtifacts();
        ArtifactModel artifact = chooseArtifactById(artifacts);

        if (hasEnoughCoins(wallet, artifact.getPrice())) {

            reduceWalletBalance(artifact.getPrice(), student, wallets);
            addBoughtArtifactToDatabase(artifact, student);
            StoreView.itemBoughtSuccesfully();

        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private static void reduceWalletBalance(Integer price, StudentModel student, WalletsDao wallets) {
        WalletModel wallet = wallets.getStudentWallet(student.getId());
        wallet.reduceBalance(price);
        wallets.updateWalletBalance(student.getId(), wallet.getBalance());
    }

    private static ArtifactsDao getArtifacts() {
        ArtifactsDao artifactsDatabase = new ArtifactsDao();
        ArrayList<ArtifactModel> artifacts = artifactsDatabase.getItems();
        StoreView.showArtifacts(artifacts);

        return artifactsDatabase;
    }


    private static void addBoughtArtifactToDatabase(ArtifactModel artifact, StudentModel student) {
        ArtifactsBoughtDao boughtArtifacts = new ArtifactsBoughtDao();
        boughtArtifacts.addToDatabase(artifact.getId(), student.getId());
    }

    private static ArtifactModel chooseArtifactById(ArtifactsDao artifacts) {

        Integer id = chooseArtifactId();
        ArtifactModel artifact = artifacts.getById(id);

        return artifact;
    }

    private static Integer chooseArtifactId() {
        Integer id = null;
        boolean isCorrect = false;

        while(!isCorrect) {

            try {
                id = StoreView.chooseArtifactId();
                isCorrect = true;
            } catch (InputMismatchException e) {
                StoreView.printWrongChoiceInfo();
            }
        }
        return id;
    }

    private static void buyArtifactWithTeammates(StudentModel student, WalletModel wallet) {
        ArtifactsDao artifacts = new ArtifactsDao();
        getGroupArtifacts(artifacts);
        ArtifactModel artifact = chooseArtifactById(artifacts);

        ArrayList<StudentModel> buyers = chooseStudentsToBuyAnArtifact(student);
        buyers.add(student);

        Integer pricePerStudent = artifact.getPrice() / buyers.size();
        if (hasEnoughCoins(wallet, pricePerStudent)) {
            createGroupTransactions(buyers, artifact, pricePerStudent, student);

        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private static void createGroupTransactions(ArrayList<StudentModel> buyers, ArtifactModel artifact, Integer pricePerStudent, StudentModel student) {

        GroupTransactionsDao transactions = new GroupTransactionsDao();
        GroupTransactionModel transaction = null;
        Integer transactionId = transactions.getNextId();

        for (StudentModel s:buyers) {
            transaction = new GroupTransactionModel(transactionId, artifact.getId(), s.getId(), pricePerStudent, "Not Marked");
            transactions.addTransactionToDatabase(transaction);
        }
        transactions.markTransaction(transaction, student);
    }

    private static void getGroupArtifacts(ArtifactsDao artifacts) {
        StoreView.showArtifacts(artifacts.getGroupArtifacts());
    }


    private static ArrayList<StudentModel> chooseStudentsToBuyAnArtifact(StudentModel student) {

        ArrayList<StudentModel> chosenStudents = new ArrayList<>();

        StudentsDao students = new StudentsDao();

        Integer id = 1000;
        while (id != 0) {
            StoreView.showStudents(students.getItems(), student);
            Scanner in = new Scanner(System.in);
            System.out.println("Choose student id, type '0' to end: ");
            id = in.nextInt();
            StudentModel s = students.getById(id);

            if (!(chosenStudents.contains(s)) && s != null) {
                chosenStudents.add(s);

            } else {
                System.out.println("This student is already added!");
            }
        }
        return chosenStudents;
    }

    private static boolean hasEnoughCoins(WalletModel wallet, Integer price) {
        if (wallet.getBalance() >= price) {
            return true;
        } else {
            return false;
        }
    }

    private static Integer chooseOption() {
        Integer choice = null;
        final Integer[] CHOICES = {0, 1, 2, 3};

        while (!Arrays.asList(CHOICES).contains(choice)){
            try {
                choice = StoreView.chooseOption();
            } catch (InputMismatchException e) {
                StoreView.printWrongChoiceInfo();
            }
        }
        return choice;
    }
}
