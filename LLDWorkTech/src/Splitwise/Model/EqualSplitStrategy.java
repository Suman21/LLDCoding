package Splitwise.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EqualSplitStrategy implements SplitStrategy {

    @Override
    public Map<User, Double> split(User paidBy, double amount, List<User> participants) {
        int headCount = participants.size();
        Map<User, Double> result = new HashMap<User, Double>();
        for (User participant : participants) {
            result.put(participant, amount/headCount);
        }
        return result;
    }
}
