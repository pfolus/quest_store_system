package models;

import java.util.ArrayList;


public class StudentModel extends UserModel {

    String level;
    Integer score;
    WalletModel wallet;
    ArrayList<DoneQuestModel> doneQuests;
    ArrayList<BoughtArtifactModel> boughtArtifacts;
    ArrayList<OrderWithTeammatesModel> ordersWithTeammates;

    public StudentModel(String name,
                        String surname, String login,
                        String password, String email,
                        String level, Integer score) {

        super(name, surname, login, password, email);
        this.level = level;
        this.score = score;
        this.wallet = null;
        this.doneQuests = null;
        this.boughtArtifacts = null;
        this.ordersWithTeammates = null;
    }

    public String getLevel() {
        return this.level;
    }

}
