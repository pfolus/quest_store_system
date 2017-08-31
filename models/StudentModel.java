package models;

import java.util.ArrayList;
import java.util.Iterator;

import models.dao.WalletsDao;
import models.dao.ArtifactsBoughtDao;


public class StudentModel extends UserModel {

    String level;
    Integer score;

    public StudentModel(String name,
                        String surname, String login,
                        String password, String email) {

        super(name, surname, login, password, email);
        this.level = "Beginner";
        this.score = 0;
    }

    public StudentModel(String name,
                        String surname, String login,
                        String password, String email,
                        String level, Integer score) {

        super(name, surname, login, password, email);
        this.level = level;
        this.score = score;
    }

    public String getLevel() {
        return this.level;
    }

    public ArrayList<BoughtArtifactModel> getBoughtArtifacts(ArtifactsBoughtDao boughtArtifactsDao) {
        return boughtArtifactsDao.get(this.id);
    }

    public WalletModel getWallet(WalletsDao walletsDao) {
        return walletsDao.get(this.id);
    }
}
