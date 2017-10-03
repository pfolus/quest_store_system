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

    private StudentModel student;
    private LevelsDao levelsDao;
    private WalletModel wallet;
    private ArtifactsBoughtDao boughtArtifactsDao;

    public StudentController(StudentModel student) {
        this.student = student;
        this.levelsDao = new LevelsDao();
        this.wallet = new WalletsDao().getStudentWallet(student.getId());
        this.boughtArtifactsDao = new ArtifactsBoughtDao();
    }

    public void runController() {
        int choice = -1;
        final int EXIT = 0;


        while(choice != EXIT){
            StudentView.showMenu();
            choice = chooseOption();

            if (choice == 1) {
                showWallet();
            } else if (choice == 2) {
                StoreController storeController = new StoreController(this.student, this.wallet);
                storeController.runController();
            } else if (choice == 3) {
                showLevel();
            } else if (choice == 4) {
                showBoughtArtifacts();
            }
        }
    }

    public void showWallet() {
        Integer balance = this.wallet.getBalance();
        StudentView.showCoinsBalance(balance);
    }

    public void showLevel() {
        String levelName = this.levelsDao.checkLevel(this.student.getScore());
        System.out.println(levelName);
    }

    public void showBoughtArtifacts() {
        ArrayList<BoughtArtifactModel> boughtArtifacts = this.boughtArtifactsDao.getItemsByStudentId(this.student.getId());
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
