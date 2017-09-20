package com.codecool.lorem.models;

public class WalletModel {

    private Integer balance;
    private Integer id;
    private Integer studentId;


    public WalletModel(Integer id, Integer studentId, Integer balance) {
        this.balance = balance;
        this.studentId = studentId;
        this.id = id;
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
