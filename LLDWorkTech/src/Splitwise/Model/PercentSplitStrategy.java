package Splitwise.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PercentSplitStrategy implements SplitStrategy {

    private final Map<User, Double> percent;

    public PercentSplitStrategy(Map<User, Double> percent) {
        this.percent = percent;
    }
    public Map<User, Double> split(User paidBy, double amount, List<User> participants) {
        HashMap<User, Double> result = new HashMap<User, Double>();
        for (User participant : participants) {
            result.put(participant, (percent.get(participant)/100) * amount);
        }
        return result;
    }
}
