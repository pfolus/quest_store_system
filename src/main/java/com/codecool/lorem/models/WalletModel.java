package com.codecool.lorem.models;

public class WalletModel extends AbstractItemModel {

    private Integer balance;
    private Integer studentId;


    public WalletModel(Integer id, Integer balance, Integer studentId) {
        super(id);
        this.balance = balance;
        this.studentId = studentId;
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

    public void increaseBalance(Integer amount) {this.balance += amount; }
}
