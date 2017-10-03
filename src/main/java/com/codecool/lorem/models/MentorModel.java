package com.codecool.lorem.models;

public class MentorModel extends UserModel {

    private Integer classId;

    public MentorModel(Integer id, String name, String surname, String login,
                       String password, String email, Integer classId) {

        super(id, name, surname, login, password, email);
        this.classId = classId;
    }

    public Integer getClassId() {
        return this.classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }
}
