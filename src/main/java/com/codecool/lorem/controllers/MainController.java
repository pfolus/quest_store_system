package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.PendingUser;
import com.codecool.lorem.views.MainView;

public class MainController {

    public static void runController() {
        PendingUser pendingUser = login();
        chooseController(pendingUser);
        DatabaseConnection.closeConnection();
    }

    private static PendingUser login() {
        LoginDao loginDao = new LoginDao();
        PendingUser pendingUser = null;
        String login;
        String password;

        while (pendingUser == null) {
            login = MainView.getLogin();
            password = MainView.getPassword();
            pendingUser = loginDao.login(login, password);
        }

        return pendingUser;
    }

    private static void chooseController(PendingUser pendingUser) {
        Integer id = pendingUser.getId();
        String type = pendingUser.getType();

        if (type.equals("student")) {
            StudentsDao studentsDao = new StudentsDao();
            StudentController.runController(studentsDao.createLoggedStudent(String.valueOf(id)));
        } else if (type.equals("mentor")) {
            MentorsDao mentorsDao = new MentorsDao();
            MentorController.runController(mentorsDao.getById(id));
        } else if (type.equals("admin")) {
            AdminsDao adminsDao = new AdminsDao();
            AdminController adminController = new AdminController(adminsDao.getById(id));
            adminController.runController();
        }
    }
}
