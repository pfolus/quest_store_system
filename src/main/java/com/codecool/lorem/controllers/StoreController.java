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

    private WalletModel wallet;
    private StudentModel student;
    private WalletsDao walletsDao;
    private GroupTransactionsDao transactionsDao;
    private ArtifactsDao artifactsDao;
    private ArtifactsBoughtDao boughtArtifactsDao;

    public StoreController(StudentModel student, WalletModel wallet) {
        this.student = student;
        this.wallet = wallet;
        this.walletsDao = new WalletsDao();
        this.transactionsDao = new GroupTransactionsDao();
        this.artifactsDao = new ArtifactsDao();
        this.boughtArtifactsDao = new ArtifactsBoughtDao();
    }

    public void runController() {

        int choice = -1;
        final int EXIT = 0;

        while (choice != EXIT) {
            StoreView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                buyArtifact();
            } else if (choice == 2) {
                buyArtifactWithTeammates();
            } else if (choice == 3) {
                managePendingTransactions();
            }
        }
    }

    private void managePendingTransactions() {
        Integer transactionId = chooseTransactionId(this.student);

        if (!transactionId.equals(0)) {
            GroupTransactionModel transaction = this.transactionsDao.getById(transactionId);
            Integer choice = StoreView.acceptOrDeclineTransaction(transaction);

            if (choice.equals(0)) {
                this.transactionsDao.removeTransaction(transaction);

            } else if (choice.equals(1)) {
                acceptTransaction(this.wallet, transaction, this.student);
            }
        }
    }

    private void acceptTransaction(WalletModel wallet, GroupTransactionModel transaction, StudentModel student) {
        if (hasEnoughCoins(wallet, transaction.getPrice())) {
            transaction.setStatus();
            this.transactionsDao.markTransaction(transaction, student);
            if (this.transactionsDao.isTransactionAcceptedByAll(transaction.getId())) {
                ArrayList<StudentModel> buyers = getBuyers(transaction);
                if (buyersHaveMoney(transaction, buyers)) {
                    addArtifactToBuyers(transaction, buyers);
                } else {
                    System.out.println("One or more of participants do not have enough money, transaction deleted.");
                }
            }
            this.transactionsDao.removeTransaction(transaction);
        } else {
            System.out.println("You don't have enough money.");
        }
    }

    private Integer chooseTransactionId(StudentModel student) {
        StoreView.showTransactions(this.transactionsDao.getTransactionsByStudentId(student.getId()));
        Integer transactionId = StoreView.chooseTransactionId();

        return transactionId;
    }

    private Boolean buyersHaveMoney(GroupTransactionModel transaction, ArrayList<StudentModel> buyers) {
        for (StudentModel s:buyers) {
            if (!(hasEnoughCoins(this.walletsDao.getStudentWallet(s.getId()), transaction.getPrice()))) {
                return false;
            }
        }
        return true;
    }

    private void addArtifactToBuyers(GroupTransactionModel transaction, ArrayList<StudentModel> buyers) {

        addBuyersToDatabase(buyers, transaction);
        for (StudentModel s:buyers) {
            reduceWalletBalance(transaction.getPrice(), s);
        }
    }

    private ArrayList<StudentModel> getBuyers(GroupTransactionModel transaction) {
        return this.transactionsDao.getTransactionParticipants(transaction.getId());
    }

    private void addBuyersToDatabase(ArrayList<StudentModel> buyers, GroupTransactionModel transaction) {
        for (StudentModel s : buyers) {
            this.boughtArtifactsDao.addToDatabase(transaction.getArtifactId(), s.getId());
        }
    }


    private void buyArtifact() {
        StoreView.showArtifacts(this.artifactsDao.getItems());
        ArtifactModel artifact = chooseArtifactById(this.artifactsDao);

        if (hasEnoughCoins(this.wallet, artifact.getPrice())) {

            reduceWalletBalance(artifact.getPrice(), this.student);
            addBoughtArtifactToDatabase(artifact, this.student);
            StoreView.itemBoughtSuccesfully();

        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private void reduceWalletBalance(Integer price, StudentModel student) {
        WalletModel wallet = this.walletsDao.getStudentWallet(student.getId());
        wallet.reduceBalance(price);
        this.walletsDao.updateWalletBalance(student.getId(), wallet.getBalance());
    }

    private void addBoughtArtifactToDatabase(ArtifactModel artifact, StudentModel student) {
        this.boughtArtifactsDao.addToDatabase(artifact.getId(), student.getId());
    }

    private ArtifactModel chooseArtifactById(ArtifactsDao artifacts) {

        Integer id = chooseArtifactId();
        ArtifactModel artifact = artifacts.getById(id);

        return artifact;
    }

    private Integer chooseArtifactId() {
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

    private void buyArtifactWithTeammates() {
        StoreView.showArtifacts(this.artifactsDao.getGroupArtifacts());
        ArtifactModel artifact = chooseArtifactById(this.artifactsDao);

        ArrayList<StudentModel> buyers = chooseStudentsToBuyAnArtifact(this.student);
        buyers.add(this.student);

        Integer pricePerStudent = artifact.getPrice() / buyers.size();
        if (hasEnoughCoins(this.wallet, pricePerStudent)) {
            createGroupTransactions(buyers, artifact, pricePerStudent, this.student);

        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private void createGroupTransactions(ArrayList<StudentModel> buyers, ArtifactModel artifact, Integer pricePerStudent, StudentModel student) {

        GroupTransactionModel transaction = null;
        Integer transactionId = this.transactionsDao.getNextId();

        for (StudentModel s:buyers) {
            transaction = new GroupTransactionModel(transactionId, artifact.getId(), s.getId(), pricePerStudent, "Not Marked");
            this.transactionsDao.addTransactionToDatabase(transaction);
        }
        this.transactionsDao.markTransaction(transaction, student);
    }

    private ArrayList<StudentModel> chooseStudentsToBuyAnArtifact(StudentModel student) {

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

    private boolean hasEnoughCoins(WalletModel wallet, Integer price) {
        if (wallet.getBalance() >= price) {
            return true;
        } else {
            return false;
        }
    }

    private Integer chooseOption() {
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
