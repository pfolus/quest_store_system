package models;


public class WalletModel {

    private Integer balance;
    private Integer id;
    private Integer studentId;

    private static Integer nextId = 1;

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

