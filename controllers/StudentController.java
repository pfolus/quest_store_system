package controllers;

import java.util.InputMismatchException;
import views.StudentView;
import views.StoreView;
import models.StudentModel;
import models.dao.WalletsDao;
import models.WalletModel;
import java.util.Arrays;

public class StudentController {

    public static void runController(StudentModel student) {
        WalletsDao walletsDao = new WalletsDao();
        walletsDao.add(new WalletModel(1));

        int choice = -1;
        final int EXIT = 0;

        while(choice != EXIT){
            StudentView.showMenu();
            choice = chooseOption();

            if(choice == 1){
                showWallet(student, walletsDao);
            } else if(choice == 2){
                enterStore();
            } else if(choice == 3){
                showLevel(student);
            }
        }
    }

    public static void showWallet(StudentModel student, WalletsDao walletsDao) {
        WalletModel wallet = student.getWallet(walletsDao);
        Integer balance = wallet.getBalance();
        StudentView.showCoinsBalance(balance);
    }

    public static void enterStore() {
        StoreView.showMenu();
    }

    public static void showLevel(StudentModel student) {
        String level = student.getLevel();
        StudentView.printLevelInfo(level);
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

    public void showCoinsBalance(StudentModel student, WalletsDao walletsDao) {
        WalletModel wallet = student.getWallet(walletsDao);
        StudentView.showCoinsBalance(wallet.getBalance());
    }
}
