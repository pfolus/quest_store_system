package controllers;


public class StoreController {


    public void buyArtifact(ArtifactsBoughtDao boughtArtifacts,
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


    public buyArtifactWithTeammates() {

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
