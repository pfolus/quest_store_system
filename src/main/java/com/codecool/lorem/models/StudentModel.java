package com.codecool.lorem.models;

public class StudentModel extends UserModel {

    private Integer score;
    private Integer classId;

    public StudentModel(Integer id, String name, String surname, String login, String password,
                        String email, Integer score, Integer classId) {

        super(id, name, surname, login, password, email);
        this.score = score;
        this.classId = classId;
    }


    public Integer getScore() {
        return score;
    }

    public Integer getClassId() {
        return classId;
    }

}
