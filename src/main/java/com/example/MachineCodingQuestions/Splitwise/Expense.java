package com.example.MachineCodingQuestions.Splitwise;

import com.example.MachineCodingQuestions.Splitwise.strategy.EqualSplitStrategy;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Expense {
    private UUID expenseId;
    private String description;
    private Double amount;
    private User paidBy;
    private Map<User,Double>splitDetails;

    public Expense(String description, Double amount, User paidBy, SplitStrategy splitStrategy, List<User> members) {
        this.expenseId = UUID.randomUUID();
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.splitDetails = splitStrategy.calculateSplit(amount, members);
    }

    public Map<User,Double> getSplitDetails(){
        return splitDetails;
    }

    public User getPaidBy(){
        return paidBy;
    }

    public Double getAmount(){
        return amount;
    }
}
