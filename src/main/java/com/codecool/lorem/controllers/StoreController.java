package com.codecool.lorem.controllers;

import java.util.Iterator;
import java.util.Arrays;
import java.util.InputMismatchException;

import com.codecool.lorem.views.StoreView;
import com.codecool.lorem.models.ArtifactModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.models.WalletModel;
import com.codecool.lorem.models.BoughtArtifactModel;
import com.codecool.lorem.models.ArtifactCategoryModel;
import com.codecool.lorem.dao.ArtifactsBoughtDao;
import com.codecool.lorem.dao.ArtifactsDao;
import com.codecool.lorem.dao.WalletsDao;
import com.codecool.lorem.dao.ArtifactCategoriesDao;


public class StoreController {

//    public static void runController(StudentModel student,
//                                     WalletModel wallet) {
//        ArtifactCategoriesDao categories = new ArtifactCategoriesDao();
//        //categories.add(cat);
//        ArtifactsDao artifacts = new ArtifactsDao();
//        ArtifactsBoughtDao boughtArtifacts = new ArtifactsBoughtDao();
//
//        int choice = -1;
//        final int EXIT = 0;
//
//        while (choice != EXIT) {
//            StoreView.showMenu();
//            choice = chooseOption();
//
//            if (choice == 1) {
//                buyArtifact(boughtArtifacts, artifacts, student, wallet);
//            } else if (choice == 2) {
//                //buyArtifactWithTeammates();
//            }
//        }
//    }
}

//    private static void buyArtifact(ArtifactsBoughtDao boughtArtifacts, ArtifactsDao artifacts,
//                            StudentModel student, WalletModel wallet) {
//
//        //showArtifactsInStore(artifacts);
        //ArtifactModel artifact = chooseArtifactById(artifacts);

//        if (hasEnoughCoins(wallet, artifact)) {
//            addBoughtItemToDao(artifact, student, boughtArtifacts);
//            StoreView.itemBoughtSuccesfully();
//            wallet.reduceBalance(artifact.getPrice());
//        } else {
//            StoreView.notEnoughMoneyInfo();


//    private static void addBoughtItemToDao(ArtifactModel artifact,
//                                    StudentModel student, ArtifactsBoughtDao boughtArtifacts) {
//        BoughtArtifactModel boughtArtifact =
//                new BoughtArtifactModel(artifact, student.getId());
//        boughtArtifacts.add(boughtArtifact);
//    }

//    private static ArtifactModel chooseArtifactById(ArtifactsDao artifacts) {
//        Integer id = chooseArtifactId();
//        ArtifactModel artifact = artifacts.get(id);
//
//        return artifact;
//    }

//    private static Integer chooseArtifactId() {
//        Integer id = null;
//        boolean isCorrect = false;
//
//        while(!isCorrect) {
//
//            try {
//                id = StoreView.chooseArtifactId();
//                isCorrect = true;
//            } catch (InputMismatchException e) {
//                StoreView.printWrongChoiceInfo();
//            }
//        }
//        return id;
//    }

    //private static BoughtArtifactModel buyArtifactWithTeammates() {

    //}

//    private static boolean hasEnoughCoins(WalletModel wallet, ArtifactModel artifactToBuy) {
//        if (wallet.getBalance() > artifactToBuy.getPrice()) {
//            return true;
//        } else {
//            return false;
//        }
//    }

//    public static void showArtifactsInStore(ArtifactsDao artifacts) {
//        Iterator iter = artifacts.getIterator();
//        while (iter.hasNext()) {
//            StoreView.showArtifact(iter.next().toString());
//        }
//    }

//    private static Integer chooseOption() {
//        Integer choice = null;
//        final Integer[] CHOICES = {0, 1, 2};
//
//        while (!Arrays.asList(CHOICES).contains(choice)){
//            try {
//                choice = StoreView.chooseOption();
//            } catch (InputMismatchException e) {
//                StoreView.printWrongChoiceInfo();
//            }
//        }
//        return choice;
//    }
