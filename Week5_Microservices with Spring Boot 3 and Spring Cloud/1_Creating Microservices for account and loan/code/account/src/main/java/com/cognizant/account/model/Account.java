package com.cognizant.account.model;


public class Account {
    private String number;
    private String type;
    private long balance;


    public String getNumber() {
        return number;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Account(String number, String type, long balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

}
