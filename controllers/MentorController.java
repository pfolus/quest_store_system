package controllers;

import models.MentorModel;
import models.StudentModel;
import views.MentorView;
import models.dao.StudentsDao;
import models.QuestModel;

import java.util.InputMismatchException;
import java.util.Iterator;

public class MentorController {

    public void runController(StudentsDao studentsDao, QuestsDao questsDao, QuestCategoriesDao questsCategoryDao) {
        int choice = 0;
        final int EXIT = 9;

        while(choice != EXIT){
            MentorView.showMenu();
            choice = MentorView.getIntInput();

            if(choice == 1){
                createStudent(studentsDao);
            } else if(choice == 2){
                addQuest(questsDao, questsCategoryDao);
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

    public void createStudent(StudentsDao studentsDao) {
        String name, surname, login,
                password, email;

        name = userView.getName();
        surname = userView.getSurname();
        login = userView.getLogin();

        while(!loginExist(login)) {
            MentorView.showExistLoginMessage();
            login = userView.getLogin();
        }
        password = userView.getPassword();
        email = userView.getEmail();

        studentsDao.add(new StudentModel(name, surname, login, password, email));

    }

    public addQuest(QuestsDao questsDao, QuestCategoriesDao questsCategoryDao) {
        String name;
        String description;
        QuestCategory category;
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
        id = null;
        while (id.equals(null)) {
            MentorView.askForCategoryId();
            Integer id = getIntInput();
        }
        category = questsCategoryDao.get(id);

        // get quest prize from input
        MentorView.provideQuestPrizeMessage();
        prize = MentorView.getIntInput();

        questsDao.add(new QuestsModel(name, category, description, prize));

    }

    public addArtifact() {

    }

    public markStudentDoneQuest() {

    }

    public markStudentUsedArtifact() {

    }

    public seeStudentsWallets() {

    }
}
