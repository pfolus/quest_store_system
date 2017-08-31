package models;


public class UserModel {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;
    private Integer id;

    private static Integer nextId = 1;

    public UserModel(String name, String surname,
              String login, String password, String email) {

        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.id = nextId++;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public Integer getId() {
        return this.id;
    }

    public String toString() {
        return "ID: " + this.id
               + " Name: " + this.name
               + " Surname: " + this.surname
               + " Login: " + this.login
               + " Email: " + this.email;
    }


}
