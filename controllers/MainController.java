package controllers;

import java.util.Iterator;
import models.UserModel;
// import models.AdminModel;
import models.MentorModel;
import models.StudentModel;
// import models.dao.AdminsDao;
import models.dao.MentorsDao;
import models.dao.StudentsDao;
import views.MainView;
// import controllers.AdminController;
import controllers.MentorController;
import controllers.StudentController;

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
