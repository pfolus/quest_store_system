package com.codecool.lorem.models;

public class UserModel extends AbstractItemModel {

    private String name;
    private String surname;
    private String login;
    private String password;
    private String email;

    public UserModel(Integer id, String name, String surname,
              String login, String password, String email) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.email = email;
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "ID: " + this.id
               + " Name: " + this.name
               + " Surname: " + this.surname
               + " Login: " + this.login
               + " Email: " + this.email;
    }

    public String getLogin() {
        return this.login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getFullName() {
        return this.name + " " + this.surname;
    }
}