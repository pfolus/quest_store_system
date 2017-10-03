package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.ClassesDao;
import com.codecool.lorem.dao.MentorsDao;
import com.codecool.lorem.dao.UsersDao;
import com.codecool.lorem.models.AdminModel;
import com.codecool.lorem.models.MentorModel;
import com.codecool.lorem.views.AdminView;
import com.codecool.lorem.views.UserView;

public class AdminController {

    private AdminModel admin;
    private MentorsDao mentorsDao;
    private ClassesDao classesDao;

    public AdminController(AdminModel admin) {
        this.admin = admin;
        this.mentorsDao = new MentorsDao();
        this.classesDao = new ClassesDao();
    }

    public void runController() {
        String choice = "";

        while (!choice.equals("0")) {
            AdminView.showMenu();
            choice = chooseOption();
        }
    }

    private String chooseOption() {
        String option = AdminView.getOption();

        if (option.equals("1")) {
            createMentor();
        } else if (option.equals("2")) {
            createClass();
        } else if (option.equals("3")) {
            editMentorProfile();
        } else if (option.equals("4")) {
            showMentorProfile();
        } else if (option.equals("5")) {
            createExperienceLevel();
        } else if (option.equals("0")) {}

        return option;
    }

    private void createMentor() {
        Integer id = UsersDao.getNextUserId();
        String name = UserView.getName();
        String surname = UserView.getSurname();
        String login = UserView.getLogin();
        String password = UserView.getPassword();
        String email = UserView.getEmail();
        Integer classId = getClassId();

        MentorModel mentor = new MentorModel(id, name, surname, login, password, email, classId);

        this.mentorsDao.addToList(mentor);
        this.mentorsDao.addToDatabase(mentor);
    }

    private Integer getClassId() {
        this.classesDao.getItems().forEach(System.out::println);

        return Integer.valueOf(AdminView.getOption());
    }

    private void createClass() {}

    private void editMentorProfile() {}

    private void showMentorProfile() {}

    private void createExperienceLevel() {}
}
