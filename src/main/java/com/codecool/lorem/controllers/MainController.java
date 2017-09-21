package com.codecool.lorem.controllers;

import java.util.ArrayList;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.views.MainView;

public class MainController {

    public static void runController() {
        ArrayList<String> userData = null;
        LoginDao loginDao = new LoginDao();

        while (userData == null) {
            userData = login(loginDao);
        }

        chooseController(userData);
        DatabaseConnection.closeConnection();
    }

    private static ArrayList<String> login(LoginDao loginDao) {
        String login = MainView.getLogin();
        String password = MainView.getPassword();

        return loginDao.login(login, password);
    }

    private static void chooseController(ArrayList<String> userData) {
        String type = userData.get(0);
        String id = userData.get(1);

        if (type.equals("student")) {
            StudentsDao studentsDao = new StudentsDao();
            StudentController.runController(studentsDao.createLoggedStudent(id));
        } else if (type.equals("mentor")) {
            MentorsDao mentorsDao = new MentorsDao();
            MentorController.runController(mentorsDao.createLoggedMentor(id));
        } else if (type.equals("admin")) {
            AdminsDao adminsDao = new AdminsDao();
            AdminController.runController(adminsDao.createLoggedAdmin(id));
        }
    }
}
