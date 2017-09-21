package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.ArtifactCategoriesDao;
import com.codecool.lorem.dao.ArtifactsDao;
import com.codecool.lorem.dao.ClassesDao;
import com.codecool.lorem.dao.QuestCategoriesDao;
import com.codecool.lorem.dao.QuestsDao;
import com.codecool.lorem.dao.QuestsDoneDao;
import com.codecool.lorem.dao.StudentsDao;
import com.codecool.lorem.dao.WalletsDao;
import com.codecool.lorem.models.ArtifactCategoryModel;
import com.codecool.lorem.models.CategoryModel;
import com.codecool.lorem.models.ClassModel;
import com.codecool.lorem.models.DoneQuestModel;
import com.codecool.lorem.models.MentorModel;
import com.codecool.lorem.models.QuestModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.models.WalletModel;
import com.codecool.lorem.views.MainView;
import com.codecool.lorem.views.MentorView;
import com.codecool.lorem.views.UserView;

public class MentorController {

    public static void runController(MentorModel mentor) {
        StudentsDao studentsDao = new StudentsDao();
        studentsDao.loadStudentsFromDb();
        QuestsDao questsDao = new QuestsDao();
        questsDao.loadQuestsFromDb();

        int choice = 0;
        final int EXIT = 9;

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
                //markStudentUsedArtifact();
            } else if (choice == 6) {
                seeStudentsWallets(studentsDao);
            } else if (choice != 9) {
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
        classesDao.showItems();

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

        // get quest name
        MentorView.provideQuestNameMessage();
        name = MentorView.getStringInput();

        // get quest description
        MentorView.provideQuestDescriptionMessage();
        description = MentorView.getStringInput();

        // lists quests categories
        questCategoriesDao.loadQuestCategoriesFromDb();
        questCategoriesDao.showItems();

        // get category correct ID from input (checks in questcategoriesDAO itemslist)
        CategoryModel category = null;
        while (category == null) {
            MentorView.provideCategoryIdMessage();
            id = MentorView.getIntInput();
            category = questCategoriesDao.get(id);
        }
        Integer categoryId = category.getId();

        // get quest prize from input
        MentorView.provideQuestPrizeMessage();
        prize = MentorView.getIntInput();

        questsDao.addQuestToDatabase(name, categoryId, description, prize);

    }

    private static void addNewArtifact() {

        ArtifactsDao artifactsDao = new ArtifactsDao();
        ArtifactCategoriesDao artifactCategoriesDao = new ArtifactCategoriesDao();
        String name;
        String description;
        ArtifactCategoryModel category;
        Integer id;
        Integer price;
        Integer categoryId;

        // get artifacts name
        MentorView.provideArtifactNameMessage();
        name = MentorView.getStringInput();

        // get artifacts description
        MentorView.provideArtifactDescriptionMessage();
        description = MentorView.getStringInput();

        // lists artifacts categories
        artifactCategoriesDao.readFromDatabase();
        artifactCategoriesDao.showItems();

        // get category correct ID from input
        category = null;
        while (category == null) {
            MentorView.provideCategoryIdMessage();
            id = MentorView.getIntInput();
            category = artifactCategoriesDao.getById(id);
        }

        categoryId = category.getId();

        // get quest prize from input
        MentorView.provideArtifactPriceMessage();
        price = MentorView.getIntInput();

        artifactsDao.addArtifact(name, categoryId, description, price);

    }

    private static void markStudentDoneQuest(StudentsDao studentsDao) {
        Integer studentId;
        StudentModel student;
        QuestsDao questsDao = new QuestsDao();
        QuestModel quest;
        QuestsDoneDao questsDoneDao = new QuestsDoneDao();

        // lists students details
        studentsDao.showItems();

        // get correct student ID:
        student = null;
        while (student == null) {
            MentorView.provideStudentIdMessage();
            Integer id = MentorView.getIntInput();
            student = studentsDao.getById(id);
        }
        studentId = student.getId();

        // list quests details
        questsDao.loadQuestsFromDb();
        questsDao.showItems();

        // get correct quest by student_id
        quest = null;
        while (quest == null) {
            MentorView.provideCategoryIdMessage();
            Integer tempId = MentorView.getIntInput();
            quest = questsDao.getById(tempId);
        }

        Integer questId = quest.getId();

        // checks if donequest with questid and studentid exists
        if (questsDoneDao.getDoneQuest(questId, studentId).equals(null)) {
            //if not, adds new quest to database
            questsDoneDao.addDoneQuestToDb(questId, studentId);
        } else {
            // if yes, update quest in database by id and load updated quest to DAO items list
            DoneQuestModel doneQuest = questsDoneDao.getDoneQuest(questId, studentId);
            questsDoneDao.updateQuest(doneQuest.getId(), doneQuest.getTimesDone() + 1);
            questsDoneDao.loadQuestFromDb(doneQuest.getId());
        }
    }

    private static void seeStudentsWallets(StudentsDao studentsDao) {
        WalletsDao walletsDao = new WalletsDao();

        walletsDao.loadAllWalletsFromDb();

        if (studentsDao.getItems().size() > 0) {

            for (WalletModel wallet : walletsDao.getItems()) {
                String fullName = studentsDao.getById(wallet.getStudentId()).getFullName();
                MainView.showString(fullName + " - " + wallet.getBalance());
            }
            MainView.newLine();
        } else {
            MainView.showString("Students list empty!\n");
        }
    }
}
//    }
//
//    public static void markStudentUsedArtifact() {
//
//    }
