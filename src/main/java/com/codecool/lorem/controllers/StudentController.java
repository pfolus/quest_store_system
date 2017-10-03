package com.codecool.lorem.controllers;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Arrays;

import com.codecool.lorem.dao.ArtifactsBoughtDao;
import com.codecool.lorem.dao.LevelsDao;
import com.codecool.lorem.models.BoughtArtifactModel;
import com.codecool.lorem.views.StudentView;
import com.codecool.lorem.views.StoreView;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.dao.WalletsDao;
import com.codecool.lorem.models.WalletModel;

public class StudentController {

    public static void runController(StudentModel student) {

        int choice = -1;
        final int EXIT = 0;

        LevelsDao levelsDao = new LevelsDao();
        WalletsDao walletsDao = new WalletsDao();

        WalletModel wallet = walletsDao.getStudentWallet(student.getId());

        while(choice != EXIT){
            StudentView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                showWallet(wallet);
            } else if (choice == 2) {
                StoreController.runController(student, wallet);
            } else if (choice == 3) {
                showLevel(levelsDao, student);
            } else if (choice == 4) {
                showBoughtArtifacts(student);
            }
        }
    }

    public static void showWallet(WalletModel wallet) {
        Integer balance = wallet.getBalance();
        StudentView.showCoinsBalance(balance);
    }

    public static void showLevel(LevelsDao levelsDao, StudentModel student) {
        String levelName = levelsDao.checkLevel(student.getScore());
        System.out.println(levelName);
    }

    public static void showBoughtArtifacts(StudentModel student) {
        ArtifactsBoughtDao boughtArtifDao = new ArtifactsBoughtDao();
        ArrayList<BoughtArtifactModel> boughtArtifacts = boughtArtifDao.getItemsByStudentId(student.getId());
        StudentView.showBoughtArtifacts(boughtArtifacts);
    }

    private static Integer chooseOption() {
        Integer choice = null;
        final Integer[] CHOICES = {0, 1, 2, 3, 4, 5};

        while (!Arrays.asList(CHOICES).contains(choice)){
            try {
                choice = StudentView.chooseOption();
            } catch (InputMismatchException e) {
                StudentView.printWrongChoiceInfo();
            }
        }
        return choice;
    }

    public void buyArtifact() {

    }

    public void buyArtifactWithTeammates() {

    }

    public void showCoinsBalance(StudentModel student, WalletModel wallet) {
        StudentView.showCoinsBalance(wallet.getBalance());
    }
}
