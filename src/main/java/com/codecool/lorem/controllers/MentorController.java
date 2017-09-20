package com.codecool.lorem.controllers;

import java.util.InputMismatchException;

import com.codecool.lorem.models.MentorModel;
import com.codecool.lorem.models.StudentModel;
import com.codecool.lorem.views.MentorView;
import com.codecool.lorem.views.UserView;
import com.codecool.lorem.dao.StudentsDao;
import com.codecool.lorem.models.QuestModel;
import com.codecool.lorem.dao.QuestsDao;
import com.codecool.lorem.models.QuestCategoryModel;
import com.codecool.lorem.dao.QuestCategoriesDao;
import com.codecool.lorem.dao.ArtifactsDao;
import com.codecool.lorem.dao.ArtifactCategoriesDao;
import com.codecool.lorem.models.ArtifactCategoryModel;
import com.codecool.lorem.models.ArtifactModel;

public class MentorController {

    public static void runController(MentorModel mentor, StudentsDao studentsDao) {
        QuestsDao questsDao = new QuestsDao();
        QuestCategoriesDao questCategoriesDao = new QuestCategoriesDao();
        ArtifactsDao artifactsDao = new ArtifactsDao();
        ArtifactCategoriesDao artifactCategoriesDao = new ArtifactCategoriesDao();

        int choice = 0;
        final int EXIT = 9;

        while(choice != EXIT){
            MentorView.showMenu();
            choice = MentorView.getIntInput();

            if(choice == 1){
                createStudent(studentsDao);
            } else if(choice == 2){
                //addQuest(questsDao, questCategoriesDao);
            } else if(choice == 3){
                //addArtifact(artifactsDao, artifactCategoriesDao);
            } else if(choice == 4){
                //markStudentDoneQuest(studentsDao);
            } else if(choice == 5){
                //markStudentUsedArtifact();
            } else if(choice == 6){
                //seeStudentsWallets();
            } else if(choice != 9){
                MentorView.showInputError();
            }
        }
    }

    public static void createStudent(StudentsDao studentsDao) {
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

        studentsDao.addStudentToDatabase(name, surname, login, password, email);
    }

    public static void addNewQuest(QuestsDao questsDao, QuestCategoriesDao questsCategoryDao) {
        //there must be QuestCategoriesDao itemsList loaded yey to run that method

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
        for (QuestCategoryModel cat: questsCategoryDao.getItems()) {
            MentorView.showString(cat.toString());
        }

        // get category correct ID from input (checks in questcategoriesDAO itemslist)
        Integer categoryId = null;
        while (categoryId == null) {
            MentorView.provideCategoryIdMessage();
            id = MentorView.getIntInput();
            categoryId = questsCategoryDao.get(id).getId();
        }

        // get quest prize from input
        MentorView.provideQuestPrizeMessage();
        prize = MentorView.getIntInput();

        questsDao.addQuestToDatabase(name, categoryId, description, prize);

    }

//    public static void addArtifact(ArtifactsDao artifactsDao, ArtifactCategoriesDao artifactCategoriesDao) {
//        String name;
//        String description;
//        ArtifactCategoryModel category;
//        Integer id;
//        Integer price;
//
//        // get artifacts name
//        MentorView.provideArtifactNameMessage();
//        name = MentorView.getStringInput();
//
//        // get artifacts description
//        MentorView.provideArtifactDescriptionMessage();
//        description = MentorView.getStringInput();
//
//        // lists artifacts categories
//        Iterator categoryIterator = artifactCategoriesDao.getIterator();
//        while (categoryIterator.hasNext()) {
//            MentorView.showString(categoryIterator.next().toString());
//        }
//
//        // get category correct ID from input
//        category = null;
//        while (category == null) {
//            MentorView.provideCategoryIdMessage();
//            id = MentorView.getIntInput();
//            category = artifactCategoriesDao.get(id);
//        }
//        // get quest prize from input
//        MentorView.provideArtifactPriceMessage();
//        price = MentorView.getIntInput();

        //artifactsDao.add(new ArtifactModel(name, category, description, price));

    }

//    public static void markStudentDoneQuest(StudentsDao studentsDao) {
//        Integer id;
//        Iterator studentsIterator = studentsDao.getIterator();
//        StudentModel student;
//
//        if(studentsIterator.hasNext()) {
//            // lists Studends details
//            while (studentsIterator.hasNext()) {
//                MentorView.showString(studentsIterator.next().toString());
//            }
//            // get category correct ID from input
//            student = null;
//            while (student == null) {
//                MentorView.provideStudentIdMessage();
//                id = MentorView.getIntInput();
//                student = studentsDao.get(id);
//            }

//        } else {
//            MentorView.showNoStudentsMessage();
//        }
//
//
//    }
//
//    public static void markStudentUsedArtifact() {
//
//    }
//
//    public static void seeStudentsWallets() {
//
//    }
