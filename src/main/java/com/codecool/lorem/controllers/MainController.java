package com.codecool.lorem.controllers;

import java.util.Iterator;

import com.codecool.lorem.models.UserModel;
// import models.AdminModel;
import com.codecool.lorem.models.MentorModel;
import com.codecool.lorem.models.StudentModel;
// import models.dao.AdminsDao;
import com.codecool.lorem.dao.MentorsDao;
import com.codecool.lorem.dao.StudentsDao;
import com.codecool.lorem.views.MainView;

public class MainController {

    public static void runController() {
        UserModel user = null;

        // AdminsDao adminsDao = new AdminsDao();
        // adminsDao.read();
        MentorsDao mentorsDao = new MentorsDao();
        mentorsDao.add(new MentorModel("Kamil", "Postrożny", "ajax", "qwerty", "lol"));
        StudentsDao studentsDao = new StudentsDao();
        studentsDao.add(new StudentModel("Mateusz", "Domagalski", "domak", "domak", "lol"));

        while (user == null) {
            user = findUser(mentorsDao, studentsDao);
        }

        chooseController(user, studentsDao);
    }

    private static UserModel findUser(MentorsDao mentorsDao, StudentsDao studentsDao) {
        String login = MainView.getLogin();
        String password = MainView.getPassword();

        Iterator iter = mentorsDao.getIterator();

        while (iter.hasNext()) {
            UserModel user = (UserModel) iter.next();

            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }

        iter = studentsDao.getIterator();

        while (iter.hasNext()) {
            StudentModel user = (StudentModel) iter.next();

            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void chooseController(UserModel user, StudentsDao studentsDao) {
        // if (user instanceof AdminModel) {
        //     AdminController.runController(user);
        // }
        if (user instanceof MentorModel) {
            MentorController.runController((MentorModel) user, studentsDao);
        } else if (user instanceof StudentModel) {
            StudentController.runController((StudentModel) user);
        }
    }
}
