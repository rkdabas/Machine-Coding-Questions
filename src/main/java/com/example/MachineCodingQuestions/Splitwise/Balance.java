package com.example.MachineCodingQuestions.Splitwise;

public class Balance {
    private User owedTo;
    private double amount;

    public Balance(User owedTo, double amount) {
        this.owedTo = owedTo;
        this.amount = amount;
    }

    public User getOwedTo(){
        return owedTo;
    }

    public double getAmount(){
        return amount;
    }
}
