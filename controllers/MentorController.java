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

import java.util.InputMismatchException;
import java.util.Iterator;

public class MentorController {

    public static void runController(MentorModel mentor, StudentsDao studentsDao) {
        QuestsDao questsDao = new QuestsDao();
        QuestCategoriesDao questCategoriesDao = new QuestCategoriesDao();

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
                addArtifact();
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

    public static void addArtifact() {

    }

    public static void markStudentDoneQuest() {

    }

    public static void markStudentUsedArtifact() {

    }

    public static void seeStudentsWallets() {

    }
}
