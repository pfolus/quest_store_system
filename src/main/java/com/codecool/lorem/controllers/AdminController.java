package com.codecool.lorem.controllers;

import com.codecool.lorem.dao.ClassesDao;
import com.codecool.lorem.dao.LevelsDao;
import com.codecool.lorem.dao.MentorsDao;
import com.codecool.lorem.dao.UsersDao;
import com.codecool.lorem.models.AdminModel;
import com.codecool.lorem.models.ClassModel;
import com.codecool.lorem.models.LevelModel;
import com.codecool.lorem.models.MentorModel;
import com.codecool.lorem.views.AdminView;
import com.codecool.lorem.views.UserView;

import javax.security.sasl.SaslServer;
import java.util.logging.Level;

public class AdminController {

    private AdminModel admin;
    private MentorsDao mentorsDao;
    private ClassesDao classesDao;
    private LevelsDao levelsDao;

    public AdminController(AdminModel admin) {
        this.admin = admin;
        this.mentorsDao = new MentorsDao();
        this.classesDao = new ClassesDao();
        this.levelsDao = new LevelsDao();
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

    private void createClass() {
        Integer id = this.classesDao.getNextId();
        String name = UserView.getName();

        ClassModel classModel = new ClassModel(id, name);

        this.classesDao.addToList(classModel);
        this.classesDao.addToDatabase(classModel);
    }

    private void editMentorProfile() {
        showMentorProfile();
        MentorModel mentorModel = this.mentorsDao.getById(AdminView.getId());

        mentorModel.setEmail(AdminView.getEmail());

        this.classesDao.getItems().forEach(System.out::println);

        mentorModel.setClassId(AdminView.getId());

        this.mentorsDao.update(mentorModel);
    }

    private void showMentorProfile() {
        this.mentorsDao.getItems().forEach(System.out::println);
    }

    private void createExperienceLevel() {
        Integer id = this.levelsDao.getNextId();
        Integer requiredScore = AdminView.getRequiredScore();
        String name = UserView.getName();

        LevelModel levelModel = new LevelModel(id, requiredScore, name);

        this.levelsDao.addToList(levelModel);
        this.levelsDao.addToDatabase(levelModel);
    }
}
