package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.*;
import com.codecool.lorem.views.MainView;
import com.codecool.lorem.views.MentorView;
import com.codecool.lorem.views.UserView;

public class MentorController {

    private StudentsDao studentsDao = new StudentsDao();
    private QuestsDao questsDao = new QuestsDao();
    private ClassesDao classesDao = new ClassesDao();
    private QuestCategoriesDao questCategoriesDao = new QuestCategoriesDao();
    private ArtifactCategoriesDao artifactCategoriesDao = new ArtifactCategoriesDao();
    private ArtifactsDao artifactsDao = new ArtifactsDao();
    private WalletsDao walletsDao = new WalletsDao();
    private ArtifactsBoughtDao boughtDao = new ArtifactsBoughtDao();
    private QuestsDoneDao questsDoneDao = new QuestsDoneDao();


    public MentorController() {

        this.studentsDao.loadStudentsFromDb();
        this.questsDao.loadQuestsFromDb();
        this.classesDao.loadClassesFromDb();
        this.questCategoriesDao.loadQuestCategoriesFromDb();
        this.artifactCategoriesDao.readFromDatabase();
        this.artifactsDao.readFromDatabase();
        this.walletsDao.loadAllWalletsFromDb();
        this.boughtDao.readFromDatabase();
    }

    public void runController(MentorModel mentor) {

        Integer choice = 0;
        final int EXIT = 9;

        while (choice != EXIT) {
            MentorView.showMenu();
            choice = MentorView.getIntInput("Choose option: ");

            if (choice == 1) {
                createStudent();
            } else if (choice == 2) {
                addNewQuest();
            } else if (choice == 3) {
                addNewArtifact();
            } else if (choice == 4) {
                markStudentDoneQuest();
            } else if (choice == 5) {
                markStudentUsedArtifact();
            } else if (choice == 6) {
                seeStudentsWallets();
            } else if (choice == EXIT) {
                System.exit(0);
            } else {
                MentorView.showInputError();
            }
        }
    }

    private void createStudent() {
        String name = UserView.getName();
        String surname = UserView.getSurname();
        String login = UserView.getLogin();
        String password = UserView.getPassword();
        String email = UserView.getEmail();

        listElements(classesDao);
        ClassModel classroom = chooseExistingObject(classesDao);
        studentsDao.addStudentToDatabase(name, surname, login, password, email, classroom.getId());
        studentsDao.loadStudentFromDbByLogin(login);
    }

    private void addNewQuest() {
        String name = MainView.getString("Provide quest's name: ");
        String description = MainView.getString("Provide quest's description: ");
        Integer prize = MentorView.getIntInput("Provide quest's prize: ");

        listElements(questCategoriesDao);
        QuestCategoryModel category = chooseExistingObject(questCategoriesDao);
        questsDao.addQuestToDatabase(name, category.getId(), description, prize);
    }

    private void addNewArtifact() {
        String name = MainView.getString("Provide artifact's name: ");
        String description = MainView.getString("Provide artifact's description: ");
        Integer price = MentorView.getIntInput("Provide artifact's price: ");
        listElements(artifactCategoriesDao);
        ArtifactCategoryModel category = chooseExistingObject(artifactCategoriesDao);
        this.artifactsDao.addArtifact(name, category.getId(), description, price);
    }

    private void markStudentDoneQuest() {
        listElements(studentsDao);
        StudentModel student = chooseExistingObject(studentsDao);

        listElements(questsDao);
        QuestModel quest = chooseExistingObject(questsDao);
        DoneQuestModel doneQuest = questsDoneDao.getDoneQuest(quest.getId(), student.getId());

        // checks if done quest exists in dao
        if (doneQuest == null) {
            questsDoneDao.addDoneQuestToDb(quest, student.getId());
        } else {
            questsDoneDao.updateQuest(doneQuest.getId(), doneQuest.getTimesDone() + 1);
            questsDoneDao.loadQuestFromDb(doneQuest.getId());
        }

        // update balance
        WalletModel wallet = walletsDao.getStudentWallet(student.getId());
        wallet.increaseBalance(quest.getPrize());
        walletsDao.updateWalletBalance(student.getId(), wallet.getBalance());
    }

    private void seeStudentsWallets() {

        if (studentsDao.getItems().size() > 0) {
            for (WalletModel wallet : walletsDao.getItems()) {
                String fullName = studentsDao.getById(wallet.getStudentId()).getFullName();
                MainView.showString(fullName + " - " + wallet.getBalance());
            }

        } else {
            MainView.showString("Students list empty!\n");
        }
    }

    private void markStudentUsedArtifact() {
        listBoughtArtifacts();
        BoughtArtifactModel boughtArtifact = chooseExistingObject(boughtDao);
        boughtArtifact.markAsUsed();
        boughtDao.updateBoughtArtifact(boughtArtifact);
    }

    private void listBoughtArtifacts() {
        for (BoughtArtifactModel bought : boughtDao.getItems()){
            String studentLogin = studentsDao.getById(bought.getStudentId()).getLogin();
            String artifactName = artifactsDao.getById(bought.getArtifactId()).getName();
            MainView.showString(bought.getId() + ". " + studentLogin + " - " + artifactName);
        }
    }

    private <T extends AbstractItemModel> void listElements (Dao<T> dao) {
        if (!dao.getItems().isEmpty()) {
            for (T element : dao.getItems()) {
                MainView.showString(element.toString());
            }
        } else MainView.showString("List is empty!");
    }

    private <T extends AbstractItemModel> T chooseExistingObject(Dao<T> dao) {
        T object = null;
        while (object == null) {
            Integer id = MentorView.getIntInput("Choose correct ID: ");
            object = dao.getById(id);
        }
        return object;
    }

}