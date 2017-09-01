package controllers;

import java.util.Iterator;
import java.util.Arrays;
import java.util.InputMismatchException;

import views.StoreView;
import models.ArtifactModel;
import models.StudentModel;
import models.WalletModel;
import models.BoughtArtifactModel;
import models.ArtifactCategoryModel;
import models.dao.ArtifactsBoughtDao;
import models.dao.ArtifactsDao;
import models.dao.WalletsDao;
import models.dao.ArtifactCategoriesDao;


public class StoreController {

    public static void runController(StudentModel student,
                                     WalletModel wallet) {
        // create Artifacts Dao
        // create ArtifactsBought Dao
        ArtifactCategoryModel cat = new ArtifactCategoryModel("Dupeczki");
        ArtifactCategoriesDao categories = new ArtifactCategoriesDao();
        categories.add(cat);
        ArtifactsDao artifacts = new ArtifactsDao();
        ArtifactModel artefakt = new ArtifactModel("Elżbieta", cat, 150);
        artifacts.add(artefakt);
        ArtifactsBoughtDao boughtArtifacts = new ArtifactsBoughtDao();

        int choice = -1;
        final int EXIT = 0;

        while(choice != EXIT){
            StoreView.showMenu();
            choice = chooseOption();

            if (choice == 1){
                buyArtifact(boughtArtifacts, artifacts, student, wallet);
            } else if(choice == 2){
                //buyArtifactWithTeammates();
            }
        }
    }

    private static void buyArtifact(ArtifactsBoughtDao boughtArtifacts, ArtifactsDao artifacts,
                            StudentModel student, WalletModel wallet) {

        showArtifactsInStore(artifacts);
        ArtifactModel artifact = chooseArtifactById(artifacts);

        if (hasEnoughCoins(wallet, artifact)) {
            addBoughtItemToDao(artifact, student, boughtArtifacts);
            StoreView.itemBoughtSuccesfully();
            wallet.reduceBalance(artifact.getPrice());
        } else {
            StoreView.notEnoughMoneyInfo();
        }
    }

    private static void addBoughtItemToDao(ArtifactModel artifact,
                                    StudentModel student, ArtifactsBoughtDao boughtArtifacts) {
        BoughtArtifactModel boughtArtifact =
                new BoughtArtifactModel(artifact, student.getId());
        boughtArtifacts.add(boughtArtifact);
    }

    private ArtifactModel chooseArtifactById(ArtifactsDao artifacts) {
        Integer id = chooseArtifactId();
        ArtifactModel artifact = artifacts.get(id);
    }

    private Integer chooseArtifactId() {
        Integer id;
        boolean isCorrect = false;

        while(!isCorrect) {

            try {
                id = StoreView.chooseArtifactId();
                isCorrect = true;
            } catch (InputMismatchException e) {
                StoreView.printWrongChoiceInfo();
            }
        }
    }

    public BoughtArtifactModel buyArtifactWithTeammates() {

    }

    private static boolean hasEnoughCoins(Wallet wallet, ArtifactModel artifactToBuy) {
        if (wallet.getBalance() >= artifactToBuy.getPrice()) {
            return true;
        } else {
            return false;
        }
    }

    public static void showArtifactsInStore(ArtifactsDao artifacts) {
        Iterator iter = artifacts.getIterator();
        while (iter.hasNext()) {
            StoreView.showArtifact(iter.next().toString());
        }
    }
}
