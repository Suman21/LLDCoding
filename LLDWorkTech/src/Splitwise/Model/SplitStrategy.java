package Splitwise.Model;

import java.util.List;
import java.util.Map;

public interface SplitStrategy {
    Map<User, Double> split(User paidBy, double amount, List<User> participants);
}
