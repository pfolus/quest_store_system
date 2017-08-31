package controllers;

import java.util.Iterator;
import models.UserModel;
// import models.AdminModel;
import models.MentorModel;
// import models.StudentModel;
// import models.dao.AdminsDao;
import models.dao.MentorsDao;
// import models.dao.StudentsDao;
import views.MainView;
// import controllers.AdminController;
import controllers.MentorController;
// import controllers.St udentController;

public class MainController {

    public static void runController() {
        UserModel user = null;

        // AdminsDao adminsDao = new AdminsDao();
        // adminsDao.read();
        MentorsDao mentorsDao = new MentorsDao();
        mentorsDao.add(new MentorModel("Kamil", "Postrożny", "ajax", "qwerty", "lol"));

        while (user == null) {
            user = findUser(mentorsDao);
        }

        chooseController(user);
    }

    private static UserModel findUser(MentorsDao mentorsDao) {
        String login = MainView.getLogin();
        String password = MainView.getPassword();

        Iterator iter = mentorsDao.getIterator();

        while (iter.hasNext()) {
            UserModel user = iter.next();

            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    private static void chooseController(UserModel user) {
        // if (user instanceof AdminModel) {
        //     AdminController.runController(user);
        // }
        if (user instanceof MentorModel) {
            MentorController.runController(user);
        }
    }
}
