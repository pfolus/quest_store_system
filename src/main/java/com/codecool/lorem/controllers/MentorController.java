package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.*;
import com.codecool.lorem.views.MainView;
import com.codecool.lorem.views.MentorView;
import com.codecool.lorem.views.UserView;

public class MentorController {

    public static void runController(MentorModel mentor) {
        StudentsDao studentsDao = new StudentsDao();
        QuestsDao questsDao = new QuestsDao();

        studentsDao.loadStudentsFromDb();
        questsDao.loadQuestsFromDb();

        Integer choice = null;
        final int EXIT = 0;

        while (choice != EXIT) {
            MentorView.showMenu();
            choice = MentorView.getIntInput();

            if (choice == 1) {
                createStudent(studentsDao);
            } else if (choice == 2) {
                addNewQuest(questsDao);
            } else if (choice == 3) {
                addNewArtifact();
            } else if (choice == 4) {
                markStudentDoneQuest(studentsDao);
            } else if (choice == 5) {
                markStudentUsedArtifact(studentsDao);
            } else if (choice == 6) {
                seeStudentsWallets(studentsDao);
            } else if (choice != 0) {
                MentorView.showInputError();
            }
        }
    }

    private static void createStudent(StudentsDao studentsDao) {

        ClassesDao classesDao = new ClassesDao();
        String name;
        String surname;
        String login;
        String password;
        String email;

        name = UserView.getName();
        surname = UserView.getSurname();
        login = UserView.getLogin();
        password = UserView.getPassword();
        email = UserView.getEmail();

        // lists classes
        classesDao.loadClassesFromDb();
        for (ClassModel classroom : classesDao.getItems()) {
            MainView.showString(classroom.toString());
        }

        // get class correct ID from input (checks in ClassesDao itemslist)
        ClassModel classroom = null;
        while (classroom == null) {
            MentorView.provideClassIdMessage();
            Integer id = MentorView.getIntInput();
            classroom = classesDao.getById(id);

            Integer classId = classroom.getId();

            studentsDao.addStudentToDatabase(name, surname, login, password, email, classId);
            studentsDao.loadStudentFromDbByLogin(login);
        }
    }

    private static void addNewQuest(QuestsDao questsDao) {
        QuestCategoriesDao questCategoriesDao = new QuestCategoriesDao();
        String name;
        String description;
        Integer id;
        Integer prize;

        MentorView.provideQuestNameMessage();
        name = MentorView.getStringInput();
        MentorView.provideQuestDescriptionMessage();
        description = MentorView.getStringInput();
        MentorView.provideQuestPrizeMessage();
        prize = MentorView.getIntInput();

        // lists quests categories
        questCategoriesDao.loadQuestCategoriesFromDb();
        for (QuestCategoryModel questCat : questCategoriesDao.getItems()) {
            MainView.showString(questCat.toString());
        }
        // get category correct ID from input (checks in questcategoriesDAO itemslist)
        CategoryModel category = null;
        while (category == null) {
            MentorView.provideCategoryIdMessage();
            id = MentorView.getIntInput();
            category = questCategoriesDao.get(id);
        }
        Integer categoryId = category.getId();
        questsDao.addQuestToDatabase(name, categoryId, description, prize);
    }

    private static void addNewArtifact() {
        ArtifactsDao artifactsDao = new ArtifactsDao();
        ArtifactCategoriesDao artifactCategoriesDao = new ArtifactCategoriesDao();
        ArtifactCategoryModel category = null;
        String name;
        String description;
        Integer price;

        // get artifacts name, description and prize
        MentorView.provideArtifactNameMessage();
        name = MentorView.getStringInput();
        MentorView.provideArtifactDescriptionMessage();
        description = MentorView.getStringInput();
        MentorView.provideArtifactPriceMessage();
        price = MentorView.getIntInput();

        // lists artifacts categories
        artifactCategoriesDao.readFromDatabase();
        for (ArtifactCategoryModel artifactCat : artifactCategoriesDao.getItems()) {
            MainView.showString(artifactCat.toString());
        }
        // get category correct ID from input
        while (category == null) {
            MentorView.provideCategoryIdMessage();
            Integer id = MentorView.getIntInput();
            category = artifactCategoriesDao.getById(id);
        }
        Integer categoryId = category.getId();
        artifactsDao.addArtifact(name, categoryId, description, price);
    }

    private static void markStudentDoneQuest(StudentsDao studentsDao) {
        StudentModel student = null;
        QuestsDao questsDao = new QuestsDao();
        QuestModel quest = null;
        WalletsDao walletsDao = new WalletsDao();
        QuestsDoneDao questsDoneDao = new QuestsDoneDao();

        // lists students details
        for (StudentModel st : studentsDao.getItems()) {
            MainView.showString(st.toString());
        }
        // get correct student ID:
        while (student == null) {
            MentorView.provideStudentIdMessage();
            Integer id = MentorView.getIntInput();
            student = studentsDao.getById(id);
        }
        Integer studentId = student.getId();

        // list quests details
        questsDao.loadQuestsFromDb();
        for (QuestModel q : questsDao.getItems()) {
            MainView.showString(q.getId() + ". " + q.getName());
        }
        // get correct quest by student_id
        while (quest == null) {
            MentorView.provideQuestNameMessage();
            Integer tempId = MentorView.getIntInput();
            quest = questsDao.getById(tempId);
        }
        Integer questId = quest.getId();

        DoneQuestModel doneQuest = questsDoneDao.getDoneQuest(questId, studentId);
        // checks if donequest exists in dao
        if (doneQuest == null) {
            questsDoneDao.addDoneQuestToDb(quest, studentId);
        } else {
            questsDoneDao.updateQuest(doneQuest.getId(), doneQuest.getTimesDone() + 1);
            questsDoneDao.loadQuestFromDb(doneQuest.getId());
        }
        // update balance
        WalletModel wallet = walletsDao.getStudentWallet(studentId);
        wallet.increaseBalance(quest.getPrize());
        walletsDao.updateWalletBalance(studentId, wallet.getBalance());
    }

    private static void seeStudentsWallets(StudentsDao studentsDao) {
        WalletsDao walletsDao = new WalletsDao();

        walletsDao.loadAllWalletsFromDb();
        if (studentsDao.getItems().size() > 0) {
            for (WalletModel wallet : walletsDao.getItems()) {
                String fullName = studentsDao.getById(wallet.getStudentId()).getFullName();
                MainView.showString(fullName + " - " + wallet.getBalance());
            }
        } else {
            MainView.showString("Students list empty!\n");
        }
    }

    public static void markStudentUsedArtifact(StudentsDao studentsDao) {
        ArtifactsBoughtDao boughtDao = new ArtifactsBoughtDao();
        ArtifactsDao artifactsDao = new ArtifactsDao();
        BoughtArtifactModel boughtArtifact = null;

        artifactsDao.readFromDatabase();
        boughtDao.readFromDatabase();

        // lists bought artifacts ( id, student login and artifacts name)
        for (BoughtArtifactModel bought : boughtDao.getItems()){
            String studentLogin = studentsDao.getById(bought.getStudentId()).getLogin();
            String artifactName = artifactsDao.getById(bought.getArtifactId()).getName();
            MainView.showString(bought.getId() + ". " + studentLogin + " - " + artifactName);
        }
        // get correct bought artifact by id
        while (boughtArtifact == null) {
            MentorView.provideBoughtArtifactIdMessage();
            Integer id = MentorView.getIntInput();
            boughtArtifact = boughtDao.getById(id);
        }
        boughtDao.deleteArtifactFromDb(boughtArtifact.getId());
    }
}