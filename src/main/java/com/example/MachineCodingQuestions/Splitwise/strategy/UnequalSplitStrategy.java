package com.example.MachineCodingQuestions.Splitwise.strategy;

import com.example.MachineCodingQuestions.Splitwise.SplitStrategy;
import com.example.MachineCodingQuestions.Splitwise.User;
import java.util.List;
import java.util.Map;

public class UnequalSplitStrategy implements SplitStrategy {
    @Override
    public Map<User, Double> calculateSplit(double totalAmount, List<User> members) {
            return new EqualSplitStrategy().calculateSplit(totalAmount,members);
    }
}
