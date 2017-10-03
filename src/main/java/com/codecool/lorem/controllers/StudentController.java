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

    private LevelsDao levelsDao;
    private WalletsDao walletsDao;
    private ArtifactsBoughtDao boughtArtifactsDao;

    public StudentController() {
        this.levelsDao = new LevelsDao();
        this.walletsDao = new WalletsDao();
        this.boughtArtifactsDao = new ArtifactsBoughtDao();
    }

    public void runController(StudentModel student) {

        int choice = -1;
        final int EXIT = 0;

        WalletModel wallet = this.walletsDao.getStudentWallet(student.getId());
        StoreController storeController = new StoreController(this.walletsDao);

        while(choice != EXIT){
            StudentView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                showWallet(wallet);
            } else if (choice == 2) {
                storeController.runController(student, wallet);
            } else if (choice == 3) {
                showLevel(student);
            } else if (choice == 4) {
                showBoughtArtifacts(student);
            }
        }
    }

    public void showWallet(WalletModel wallet) {
        Integer balance = wallet.getBalance();
        StudentView.showCoinsBalance(balance);
    }

    public void showLevel(StudentModel student) {
        String levelName = this.levelsDao.checkLevel(student.getScore());
        System.out.println(levelName);
    }

    public void showBoughtArtifacts(StudentModel student) {
        ArrayList<BoughtArtifactModel> boughtArtifacts = this.boughtArtifactsDao.getItemsByStudentId(student.getId());
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
}
