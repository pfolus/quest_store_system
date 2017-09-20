package com.codecool.lorem.models;

public class AdminModel extends UserModel {

    public AdminModel(Integer id, String name, String surname,
            String login, String password, String email) {

        super(id, name, surname, login, password, email);
    }
}
