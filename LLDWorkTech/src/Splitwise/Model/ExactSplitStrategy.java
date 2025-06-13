package Splitwise.Model;

import java.util.List;
import java.util.Map;

public class ExactSplitStrategy implements SplitStrategy {

    private final Map<User, Double> split;

    public ExactSplitStrategy(Map<User, Double> split) {
        this.split = split;
    }

    public Map<User, Double> split(User paidBy, double amount, List<User> participants) {
        return  this.split;
    }
}
