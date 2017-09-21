package com.codecool.lorem.controllers;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.InputMismatchException;

import com.codecool.lorem.views.StoreView;
import com.codecool.lorem.models.ArtifactModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.models.WalletModel;
import com.codecool.lorem.dao.ArtifactsBoughtDao;
import com.codecool.lorem.dao.ArtifactsDao;
import com.codecool.lorem.dao.WalletsDao;


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
                //buyArtifactWithTeammates();
            }
        }
    }

    private static void buyArtifact(StudentModel student, WalletModel wallet) {


        ArtifactsDao artifacts = getArtifacts();
        ArtifactModel artifact = chooseArtifactById(artifacts);

        if (hasEnoughCoins(wallet, artifact)) {

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
        artifactsDatabase.readFromDatabase();
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

    //private static BoughtArtifactModel buyArtifactWithTeammates() {

    //}

    private static boolean hasEnoughCoins(WalletModel wallet, ArtifactModel artifactToBuy) {
        if (wallet.getBalance() > artifactToBuy.getPrice()) {
            return true;
        } else {
            return false;
        }
    }

    private static Integer chooseOption() {
        Integer choice = null;
        final Integer[] CHOICES = {0, 1, 2};

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
