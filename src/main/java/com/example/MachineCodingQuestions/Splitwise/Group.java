package com.example.MachineCodingQuestions.Splitwise;

import java.nio.DoubleBuffer;
import java.util.*;

public class Group {
    private UUID groupId;
    private String name;
    private List<User>members;
    private List<Expense>expenses;

    public Group(String name) {
        this.groupId = UUID.randomUUID();
        this.name = name;
        this.members = new ArrayList<>();
        this.expenses = new ArrayList<>();
    }

    public void addMember(User user){
        members.add(user);
    }

    public void removeMember(User user){
        members.remove(user);
    }

    public void addExpense(String description, double amount,User paidBy,SplitStrategy splitStrategy){
        Expense expense=new Expense(description,amount,paidBy,splitStrategy,members);
        expenses.add(expense);
        NotifyUsers("new expense added: "+description+" for $"+amount);
    }

    private void NotifyUsers(String message){
        for(User member:members){
            member.notify(new Notification(message));
        }
    }

    public List<Transaction>simplifyDebts(){
        Map<User, Double> netBalances = new HashMap<>();

        // Calculate net balances
        for (Expense expense : expenses) {
            Map<User, Double> splitDetails = expense.getSplitDetails();
            for (Map.Entry<User, Double> entry : splitDetails.entrySet()) {
                netBalances.put(entry.getKey(), netBalances.getOrDefault(entry.getKey(), 0.0) - entry.getValue());
            }
            netBalances.put(expense.getPaidBy(), netBalances.getOrDefault(expense.getPaidBy(), 0.0) + expense.getAmount());
        }

        // Greedy algorithm for debt minimization
        List<Transaction> transactions = new ArrayList<>();
        PriorityQueue<Map.Entry<User, Double>> debtors = new PriorityQueue<>(
                (a, b) -> Double.compare(a.getValue(), b.getValue())
        );
        PriorityQueue<Map.Entry<User, Double>> creditors = new PriorityQueue<>(
                (a, b) -> Double.compare(b.getValue(), a.getValue())
        );

        for (Map.Entry<User, Double> entry : netBalances.entrySet()) {
            if (entry.getValue() > 0) creditors.add(entry);
            else if (entry.getValue() < 0) debtors.add(entry);
        }

        while (!debtors.isEmpty() && !creditors.isEmpty()) {
            Map.Entry<User, Double> debtor = debtors.poll();
            Map.Entry<User, Double> creditor = creditors.poll();

            double settlementAmount = Math.min(-debtor.getValue(), creditor.getValue());
            transactions.add(new Transaction(debtor.getKey(), creditor.getKey(), settlementAmount));

            debtor.setValue(debtor.getValue() + settlementAmount);
            creditor.setValue(creditor.getValue() - settlementAmount);

            if (debtor.getValue() < 0) debtors.add(debtor);
            if (creditor.getValue() > 0) creditors.add(creditor);
        }
        return transactions;
    }
}
