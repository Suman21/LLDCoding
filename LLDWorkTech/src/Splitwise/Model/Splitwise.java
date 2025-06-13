package Splitwise.Model;

import Splitwise.Exception.WrongUserException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    Map<String, User> userIdMap;
    Map<String, Map<String, Double>> balance;

    public Splitwise() {
        userIdMap = new HashMap<>();
        balance = new HashMap<>();
    }

    public void addUser(User user)
    {
        userIdMap.put(user.getUserId(), user);
        balance.put(user.getUserId(), new HashMap<>());
    }

    public void addExpense(String paidByUserId, double amount, List<String> participantsId, SplitStrategy splitStrategy) throws WrongUserException
    {
        if(!userIdMap.containsKey(paidByUserId))
            throw new WrongUserException("Wrong User expense!!");
        User paidBy = userIdMap.get(paidByUserId);
        List<User> participant = new ArrayList<>();
        for(String participantId : participantsId)
        {
            participant.add(userIdMap.get(participantId));
        }
        Expense expense = new Expense(paidBy, amount, splitStrategy);
        Map<User, Double> result = expense.getSplit(participant);
        for(Map.Entry<User, Double> entry : result.entrySet())
        {
            User user = entry.getKey();
            if(user == paidBy)
                continue;
            double splitAmount = entry.getValue();
            balance.get(user.getUserId()).put(paidByUserId,
                    balance.get(user.getUserId()).get(paidByUserId) + splitAmount
                    );
            balance.get(paidByUserId).put(user.getUserId(), balance.get(paidByUserId).get(user.getUserId()) - splitAmount);
        }
    }

    public void showBalance()
    {
        for(String u1 : balance.keySet())
        {
            for (String u2 : balance.get(u1).keySet())
            {
                double amount = balance.get(u1).get(u2);
                System.out.println(userIdMap.get(u1).getUserName() + " owes " + userIdMap.get(u2).getUserName() + " : " + amount);
            }
        }
    }
}
