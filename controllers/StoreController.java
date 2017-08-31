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
        }
    }

    private void addBoughtItemToDao(ArtifactModel artifact, StudentModel student) {
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
