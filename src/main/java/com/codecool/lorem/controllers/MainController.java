package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.*;
import com.codecool.lorem.models.PendingUserModel;
import com.codecool.lorem.views.MainView;

public class MainController {

    public static void runController() {
        PendingUserModel pendingUser = login();
        chooseController(pendingUser);
        DatabaseConnection.closeConnection();
    }

    private static PendingUserModel login() {
        LoginDao loginDao = new LoginDao();
        PendingUserModel pendingUser = null;
        String login;
        String password;

        while (pendingUser == null) {
            login = MainView.getLogin();
            password = MainView.getPassword();
            pendingUser = loginDao.login(login, password);
        }

        return pendingUser;
    }

    private static void chooseController(PendingUserModel pendingUser) {
        String id = pendingUser.getId();
        String type = pendingUser.getType();

        if (type.equals("student")) {
            StudentsDao studentsDao = new StudentsDao();
            StudentController.runController(studentsDao.createLoggedStudent(id));
        } else if (type.equals("mentor")) {
            MentorsDao mentorsDao = new MentorsDao();
            MentorController mentorController = new MentorController();
            mentorController.runController(mentorsDao.createLoggedMentor(id));
        } else if (type.equals("admin")) {
            AdminsDao adminsDao = new AdminsDao();
            AdminController.runController(adminsDao.createLoggedAdmin(id));
        }
    }
}
