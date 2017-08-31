package controllers;


public class StoreController {


    public BoughtArtifactModel buyArtifact(ArtifactsBoughtDao boughtArtifacts,
                                           ArtifactsDao artifacts, StudentModel student) {

        Integer id;
        boolean hasEnoughCoins;

        showArtifactsInStore(artifacts);
        id = chooseArtifactId;
        ArtifactModel artifact = artifacts.get(id);

        if (hasEnoughCoins(student.getWallet(), artifact)) {
            BoughtArtifactModel boughtArtifact =
                    new BoughtArtifactModel(artifact, student.getId());
            return boughtArtifact;
        } else {
            StoreView.notEnoughMoneyInfo();
            return null;
        }
    }


