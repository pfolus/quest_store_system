package controllers;

import models.MentorModel;
import models.StudentModel;
import views.MentorView;
import models.dao.StudentsDao;

import java.util.InputMismatchException;

public class MentorController {

    public void run(StudentsDao studentsDao) {
        int choice = 0;
        final int EXIT = 9;

        while(choice != EXIT){
            MentorView.showMenu();
            choice = MentorView.getIntInput();

            if(choice == 1){
                createStudent(studentsDao);
            } else if(choice == 2){
                addQuest();
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

    public addQuest() {

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
