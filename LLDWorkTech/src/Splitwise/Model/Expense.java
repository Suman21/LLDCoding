package Splitwise.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Expense {
    private User paidBy;
    private double amount;
    private SplitStrategy splitStrategy;

    public Expense(User paidBy, double amount, SplitStrategy splitStrategy) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.splitStrategy = splitStrategy;
    }

    public Map<User, Double> getSplit(List<User> participants) {
        return splitStrategy.split(paidBy, amount, participants);
    }

}
