package com.example.MachineCodingQuestions.Splitwise;

public class Transaction {
    private User fromUser;
    private User toUser;
    private double amount;

    public Transaction(User fromUser, User toUser, double amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }
    public void executeTransaction(){
        System.out.println(fromUser.getName()+" pays "+toUser.getName() + " : $" + amount);
    }
}
