package controllers;

import models.MentorModel;
import models.StudentModel;
import views.MentorView;
import views.UserView;
import models.dao.StudentsDao;
import models.QuestModel;
import models.dao.QuestsDao;
import models.QuestCategoryModel;
import models.dao.QuestCategoriesDao;
import models.dao.ArtifactsDao;
import models.dao.ArtifactCategoriesDao;
import models.ArtifactCategoryModel;
import models.ArtifactModel;

import java.util.InputMismatchException;
import java.util.Iterator;

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
                addQuest(questsDao, questCategoriesDao);
            } else if(choice == 3){
                addArtifact(artifactsDao, artifactCategoriesDao);
            } else if(choice == 4){
                markStudentDoneQuest(studentsDao);
            } else if(choice == 5){
                markStudentUsedArtifact();
            } else if(choice == 6){
                seeStudentsWallets();
            } else if(choice != 9){
                MentorView.showInputError();
            }
        }
    }

    public static void createStudent(StudentsDao studentsDao) {
        String name, surname, login,
                password, email;

        name = UserView.getName();
        surname = UserView.getSurname();
        login = UserView.getLogin();
        password = UserView.getPassword();
        email = UserView.getEmail();

        studentsDao.add(new StudentModel(name, surname, login, password, email));

    }

    public static void addQuest(QuestsDao questsDao, QuestCategoriesDao questsCategoryDao) {
        String name;
        String description;
        QuestCategoryModel category;
        Integer id;
        Integer prize;

        // get quest name
        MentorView.provideQuestNameMessage();
        name = MentorView.getStringInput();

        // get quest description
        MentorView.provideQuestDescriptionMessage();
        description = MentorView.getStringInput();

        // lists quests categories
        Iterator categoryIterator = questsCategoryDao.getIterator();
        while (categoryIterator.hasNext()) {
            MentorView.showString(categoryIterator.next().toString());
        }

        // get category correct ID from input
        category = null;
        while (category == null) {
            MentorView.askForCategoryId();
            id = MentorView.getIntInput();
            category = questsCategoryDao.get(id);
        }
        // get quest prize from input
        MentorView.provideQuestPrizeMessage();
        prize = MentorView.getIntInput();

        questsDao.add(new QuestModel(name, category, description, prize));

    }

    public static void addArtifact(ArtifactsDao artifactsDao, ArtifactCategoriesDao artifactCategoriesDao) {
        String name;
        String description;
        ArtifactCategoryModel category;
        Integer id;
        Integer price;

        // get artifacts name
        MentorView.provideArtifactNameMessage();
        name = MentorView.getStringInput();

        // get artifacts description
        MentorView.provideArtifactDescriptionMessage();
        description = MentorView.getStringInput();

        // lists artifacts categories
        Iterator categoryIterator = artifactCategoriesDao.getIterator();
        while (categoryIterator.hasNext()) {
            MentorView.showString(categoryIterator.next().toString());
        }

        // get category correct ID from input
        category = null;
        while (category == null) {
            MentorView.askForCategoryId();
            id = MentorView.getIntInput();
            category = artifactCategoriesDao.get(id);
        }
        // get quest prize from input
        MentorView.provideArtifactPriceMessage();
        price = MentorView.getIntInput();

        artifactsDao.add(new ArtifactModel(name, category, description, price));

    }

    public static void markStudentDoneQuest() {

    }

    public static void markStudentUsedArtifact() {

    }

    public static void seeStudentsWallets() {

    }
}
