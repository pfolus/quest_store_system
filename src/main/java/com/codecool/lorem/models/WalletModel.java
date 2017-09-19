package com.codecool.lorem.models;

public class WalletModel {

    private Integer balance;
    private Integer id;
    private Integer studentId;

    private static Integer nextId = 1;


    public WalletModel(Integer studentId) {
        this.balance = 0;
        this.studentId = studentId;
        this.id = nextId++;
    }

    public WalletModel(Integer balance, Integer studentId) {
        this.balance = balance;
        this.studentId = studentId;
        this.id = nextId++;
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void reduceBalance(Integer amount) {
        this.balance -= amount;
    }
}
