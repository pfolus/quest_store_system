package models;


public class StudentModel extends UserModel {

    public StudentModel(String name, String surname,
                        String login, String password, String email) {

        super(name, surname, login, password, email);
    }
}
