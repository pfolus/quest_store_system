package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.*;
import com.codecool.lorem.views.MainView;
import com.codecool.lorem.views.MentorView;
import com.codecool.lorem.views.UserView;

public class MentorController {

    private StudentsDao studentsDao;
    private QuestsDao questsDao;
    private ClassesDao classesDao;
    private QuestCategoriesDao questCategoriesDao;
    private ArtifactCategoriesDao artifactCategoriesDao;
    private ArtifactsDao artifactsDao;
    private WalletsDao walletsDao;
    private ArtifactsBoughtDao boughtDao;
    private QuestsDoneDao questsDoneDao;


    public MentorController() {
        studentsDao = new StudentsDao();
        questsDao = new QuestsDao();
        classesDao = new ClassesDao();
        questCategoriesDao = new QuestCategoriesDao();
        artifactCategoriesDao = new ArtifactCategoriesDao();
        artifactsDao = new ArtifactsDao();
        walletsDao = new WalletsDao();
        boughtDao = new ArtifactsBoughtDao();
        questsDoneDao = new QuestsDoneDao();
    }

    public void runController() {

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
        Integer id = UsersDao.getNextUserId();
        String name = UserView.getName();
        String surname = UserView.getSurname();
        String login = UserView.getLogin();
        String password = UserView.getPassword();
        String email = UserView.getEmail();

        Boolean classesListNotEmpty = listElements(classesDao);
        if (classesListNotEmpty) {
            ClassModel classroom = chooseExistingObject(classesDao);
            StudentModel student = new StudentModel(id, name, surname, login, password,
                    email, 0, classroom.getId());
            WalletModel wallet = new WalletModel(walletsDao.getNextId(), 0, id);

            studentsDao.addToDatabase(student);
            studentsDao.addToList(student);

            walletsDao.addToDatabase(wallet);
            walletsDao.addToList(wallet);
        } else MainView.showString("classes list empty!");
    }

    private void addNewQuest() {
        String name = MainView.getString("Provide quest's name: ");
        String description = MainView.getString("Provide quest's description: ");
        Integer prize = MentorView.getIntInput("Provide quest's prize: ");

        listElements(questCategoriesDao);
        QuestCategoryModel category = chooseExistingObject(questCategoriesDao);

        QuestModel quest = new QuestModel(
                questsDao.getNextId(), name, category.getId(), description, prize);

        questsDao.addToDatabase(quest);
        questsDao.addToList(quest);
    }

    private void addNewArtifact() {
        String name = MainView.getString("Provide artifact's name: ");
        String description = MainView.getString("Provide artifact's description: ");
        Integer price = MentorView.getIntInput("Provide artifact's price: ");

        Boolean artifactsListNotEmpty = listElements(artifactCategoriesDao);
        if (artifactsListNotEmpty){
            ArtifactCategoryModel category = chooseExistingObject(artifactCategoriesDao);

            ArtifactModel artifact = new ArtifactModel(artifactsDao.getNextId(), name,
                    category.getId(), description, price);

            artifactsDao.addToDatabase(artifact);
            artifactsDao.addToList(artifact);
        } else MainView.showString("Empty artifacts list!");
    }

    private void markStudentDoneQuest() {
        Boolean studentsListNotEmpty = listElements(studentsDao);
        if (studentsListNotEmpty){
            StudentModel student = chooseExistingObject(studentsDao);

            Boolean questsListNotEmpty = listElements(questsDao);
            if(questsListNotEmpty) {
                QuestModel quest = chooseExistingObject(questsDao);
                DoneQuestModel doneQuest = new DoneQuestModel(
                        questsDoneDao.getNextId(), quest.getName(), quest.getCategoryId(),
                        quest.getDescription(), quest.getPrize(), quest.getId(), student.getId());

                questsDoneDao.addToDatabase(doneQuest);
                questsDoneDao.addToList(doneQuest);
                // update balance
                WalletModel wallet = walletsDao.getStudentWallet(student.getId());
                wallet.increaseBalance(quest.getPrize());
                walletsDao.updateWalletBalance(student.getId(), wallet.getBalance());
            } else MainView.showString("Empty quests list!");
        } else MainView.showString("Empty students list!");
    }

    private void seeStudentsWallets() {

        if (studentsDao.getItems().size() > 0) {
            for (WalletModel wallet : walletsDao.getItems()) {
                String fullName = studentsDao.getById(wallet.getStudentId()).getFullName();
                MainView.showString(fullName + " - " + wallet.getBalance());
            }

        } else MainView.showString("Students list empty!\n");
    }

    private void markStudentUsedArtifact() {
        Boolean boughtArtifactsListNotEmpty = listBoughtArtifacts();
        if (boughtArtifactsListNotEmpty){
            BoughtArtifactModel boughtArtifact = chooseExistingObject(boughtDao);
            boughtArtifact.markAsUsed();
            boughtDao.updateBoughtArtifact(boughtArtifact);
        } else {
            MainView.showString("There's no bought artifact's on the list!");
        }
    }

    private Boolean listBoughtArtifacts() {

        if (!boughtDao.getItems().isEmpty()){
            for (BoughtArtifactModel bought : boughtDao.getItems()){
                String studentLogin = studentsDao.getById(bought.getStudentId()).getLogin();
                String artifactName = artifactsDao.getById(bought.getArtifactId()).getName();
                MainView.showString(bought.getId() + ". " + studentLogin + " - " + artifactName);
            } return true;
        } else MainView.showString("List is empty"); return false;
    }

    private <T extends AbstractItemModel> Boolean listElements (Dao<T> dao) {

        if (!dao.getItems().isEmpty()) {
            for (T element : dao.getItems()) {
                MainView.showString(element.toString());
            }
            return true;
        } else return false;
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