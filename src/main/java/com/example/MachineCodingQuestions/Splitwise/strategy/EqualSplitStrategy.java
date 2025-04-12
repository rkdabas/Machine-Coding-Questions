package com.example.MachineCodingQuestions.Splitwise.strategy;

import com.example.MachineCodingQuestions.Splitwise.SplitStrategy;
import com.example.MachineCodingQuestions.Splitwise.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> calculateSplit(double totalAmount, List<User> members) {
        Map<User,Double>splitMap=new HashMap<>();
        double perPersonShare=totalAmount/members.size();
        for(User member:members){
            splitMap.put(member,perPersonShare);
        }
        return splitMap;
    }
}
