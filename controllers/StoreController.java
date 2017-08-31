package controllers;


public class StoreController {


    public void buyArtifact(ArtifactsBoughtDao boughtArtifacts,
                                           ArtifactsDao artifacts, StudentModel student) {

        showArtifactsInStore(artifacts);
        ArtifactModel artifact = chooseArtifactById(artifacts);

        if (hasEnoughCoins(student.getWallet(), artifact)) {
            addBoughtItemToDao(artifact, student);
            StoreView.itemBoughtSuccesfully();
            student.getWallet().reduceBalance(artifact.getPrice());
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
