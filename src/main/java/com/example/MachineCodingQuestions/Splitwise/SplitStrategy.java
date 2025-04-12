package com.example.MachineCodingQuestions.Splitwise;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    Map<User,Double> calculateSplit(double totalAmount, List<User> members);
}
