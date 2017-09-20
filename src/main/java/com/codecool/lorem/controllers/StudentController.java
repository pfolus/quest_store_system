package com.codecool.lorem.controllers;

import java.util.InputMismatchException;
import java.util.Arrays;

import com.codecool.lorem.views.StudentView;
import com.codecool.lorem.views.StoreView;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.dao.WalletsDao;
import com.codecool.lorem.models.WalletModel;

public class StudentController {

    public static void runController(StudentModel student) {

        int choice = -1;
        final int EXIT = 0;

        while(choice != EXIT){
            StudentView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                //showWallet(student, wallet);
            } else if (choice == 2) {
                StoreController.runController(student);
            } else if (choice == 3) {
                //showLevel(student);
            } else if (choice == 4) {
                showBoughtArtifacts(student);
            }
        }
    }

//    public static void showWallet(StudentModel student, WalletModel wallet) {
//        Integer balance = wallet.getBalance();
//        StudentView.showCoinsBalance(balance);
//    }

//    public static void showLevel(StudentModel student) {
//        String level = student.getLevel();
//        StudentView.printLevelInfo(level);
//    }

    public static void showBoughtArtifacts(StudentModel student) {
        //ArtifactsBoughtDao wczytanie kupionych z pliku po id studenta
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
