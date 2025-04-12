package com.example.MachineCodingQuestions.Splitwise;

import com.example.MachineCodingQuestions.Splitwise.strategy.EqualSplitStrategy;

import java.util.List;

public class Main {
    public static void main(String args[]){
        User user1=new User("Sahil","sahil@gmail.com");
        User user2=new User("Rohan","rohan@gmail.com");
        User user3=new User("Pulkit","pulkit@gmail.com");

        Group group=new Group("split the money!!!!");
        group.addMember(user1);
        group.addMember(user2);
        group.addMember(user3);

        group.addExpense("Lunch",90,user1,new EqualSplitStrategy());
        group.addExpense("Dinner",150,user2,new EqualSplitStrategy());

        List<Transaction>transactions=group.simplifyDebts();
        for(Transaction transaction:transactions){
            transaction.executeTransaction();
        }
    }
}
