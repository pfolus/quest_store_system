package com.codecool.lorem.controllers;

import java.util.InputMismatchException;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.*;
import com.codecool.lorem.views.MainView;
import com.codecool.lorem.views.MentorView;
import com.codecool.lorem.views.UserView;

public class MentorController {

    public static void runController(MentorModel mentor) {
        StudentsDao studentsDao = new StudentsDao();
        QuestsDao questsDao = new QuestsDao();

        int choice = 0;
        final int EXIT = 9;

        while(choice != EXIT){
            MentorView.showMenu();
            choice = MentorView.getIntInput();

            if(choice == 1){
                createStudent(studentsDao);
            } else if(choice == 2){
                addNewQuest(questsDao);
            } else if(choice == 3){
                //addArtifact();
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
            MentorView.showString(classroom.toString());
        }
        MainView.newLine();

        // get class correct ID from input (checks in ClassesDao itemslist)
        ClassModel classroom = null;
        while (classroom == null) {
            MentorView.provideClassIdMessage();
            Integer id = MentorView.getIntInput();
            classroom = classesDao.getById(id);

        Integer classId = classroom.getId();

            studentsDao.addStudentToDatabase(name, surname, login, password, email, classId);
        }
    }

    public static void addNewQuest(QuestsDao questsDao) {

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
        for (QuestCategoryModel cat: questCategoriesDao.getItems()) {
            MentorView.showString(cat.toString());
        }

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

//    public static void addArtifact(ArtifactsDao artifactsDao, ArtifactCategoriesDao artifactCategoriesDao) {
//          ArtifactsDao artifactsDao = new ArtifactsDao();
//          ArtifactCategoriesDao artifactCategoriesDao = new ArtifactCategoriesDao();
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
