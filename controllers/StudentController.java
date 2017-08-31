public class StudentController {

    public buyArtifact() {

    }

    public buyArtifactWithTeammates() {

    }

    public void showCoinsBalance(StudentModel student, WalletsDao walletsDao) {
        WalletModel wallet = student.getWallet(walletsDao);
        StudentView.showCoinsBalance(wallet.getBalance());
    }
}
