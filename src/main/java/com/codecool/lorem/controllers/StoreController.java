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

    public static void runController(StudentModel student, WalletModel wallet) {

        int choice = -1;
        final int EXIT = 0;

        while (choice != EXIT) {
            StoreView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                buyArtifact(student, wallet);
            } else if (choice == 2) {
                buyArtifactWithTeammates(student, wallet);
            } else if (choice == 3) {
                managePendingTransactions(student);
            }
        }
    }

    private static void managePendingTransactions(StudentModel student) {
        GroupTransactionsDao transactions = new GroupTransactionsDao();
        StoreView.showTransactions(transactions.getTransactionsByStudentId(student.getId()));
        Integer transactionId = StoreView.chooseTransactionId();

        if (!transactionId.equals(0)) {
            GroupTransactionModel transaction = transactions.getById(transactionId);
            Integer choice = StoreView.acceptOrDeclineTransaction(transaction);

            if (choice.equals(0)) {
                transactions.removeTransaction(transaction);

            } else if (choice.equals(1)) {
                transaction.setStatus();
                transactions.markTransaction(transaction, student);
                if (transactions.isTransactionAcceptedByAll(transactionId)) {
                    addBoughtArtifactsToBuyers(transaction, transactions);

                    }
                }
            }
        }

    private static void addBoughtArtifactsToBuyers(GroupTransactionModel transaction, GroupTransactionsDao transactions) {
        ArtifactsBoughtDao boughtArtifacts = new ArtifactsBoughtDao();

        ArrayList<StudentModel> buyers = transactions.getTransactionParticipants(transaction.getId());
        for (StudentModel s : buyers) {
            boughtArtifacts.addBoughtArtifactToDatabase(transaction.getArtifactId(), s.getId());
        }
    }


    private static void buyArtifact(StudentModel student, WalletModel wallet) {


        ArtifactsDao artifacts = getArtifacts();
        ArtifactModel artifact = chooseArtifactById(artifacts);

        if (hasEnoughCoins(wallet, artifact.getPrice())) {

            WalletsDao walletsDao = new WalletsDao();
            wallet.reduceBalance(artifact.getPrice());
            walletsDao.updateWalletBalance(student.getId(), wallet.getBalance());
            addBoughtArtifactToDatabase(artifact, student);
            StoreView.itemBoughtSuccesfully();

        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private static ArtifactsDao getArtifacts() {
        ArtifactsDao artifactsDatabase = new ArtifactsDao();
        //artifactsDatabase.readFromDatabase();
        ArrayList<ArtifactModel> artifacts = artifactsDatabase.getItems();
        StoreView.showArtifacts(artifacts);

        return artifactsDatabase;
    }


    private static void addBoughtArtifactToDatabase(ArtifactModel artifact, StudentModel student) {
        ArtifactsBoughtDao boughtArtifacts = new ArtifactsBoughtDao();
        boughtArtifacts.addBoughtArtifactToDatabase(artifact.getId(), student.getId());
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

        ArrayList<StudentModel> buyers = chooseStudentsToBuyAnArtifact();
        buyers.add(student);

        Integer pricePerStudent = artifact.getPrice() / buyers.size();
        if (hasEnoughCoins(wallet, pricePerStudent)) {
            createGroupTransactions(buyers, artifact, pricePerStudent);

        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private static void createGroupTransactions(ArrayList<StudentModel> buyers, ArtifactModel artifact, Integer pricePerStudent) {

        GroupTransactionsDao transactions = new GroupTransactionsDao();
        Integer transactionId = transactions.getNextId();

        for (StudentModel s:buyers) {
            GroupTransactionModel transaction = new GroupTransactionModel(transactionId, artifact.getId(), s.getId(), pricePerStudent, "Not Marked");
            transactions.addTransactionToDatabase(transaction);
        }
    }

    private static void getGroupArtifacts(ArtifactsDao artifacts) {
        StoreView.showArtifacts(artifacts.getGroupArtifacts());
    }


    private static ArrayList<StudentModel> chooseStudentsToBuyAnArtifact() {

        ArrayList<StudentModel> chosenStudents = new ArrayList<>();

        StudentsDao students = new StudentsDao();

        Integer id = 1000;
        while (id != 0) {
            StoreView.showStudents(students.getItems());
            Scanner in = new Scanner(System.in);
            System.out.println("Choose student id, type '0' to end: ");
            id = in.nextInt();
            StudentModel student = students.getById(id);

            if (!(chosenStudents.contains(student)) && student != null) {
                chosenStudents.add(student);

            } else {
                System.out.println("This student is already added!");
            }
        }
        return chosenStudents;
    }

    private static boolean hasEnoughCoins(WalletModel wallet, Integer price) {
        if (wallet.getBalance() > price) {
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
