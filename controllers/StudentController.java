public class StudentController {

    public void runController(StudentModel student, WalletsDao walletsDao) {
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
            } else if(choice == 4){
                markStudentDoneQuest();
            } else if(choice == 5){
                markStudentUsedArtifact();
            } else if(choice == 6){
                seeStudentsWallets();
            } else if(choice != 9){
                MentorView.showInputError();
            }
        }
    }


    }

    public buyArtifactWithTeammates() {

    }

    public void showCoinsBalance(StudentModel student, WalletsDao walletsDao) {
        WalletModel wallet = student.getWallet(walletsDao);
        StudentView.showCoinsBalance(wallet.getBalance());
    }
}
