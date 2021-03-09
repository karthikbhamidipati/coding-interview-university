package dailycodingproblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CumulativeSum {
    public List<Integer> getSubList(List<Integer> numbers, int K) {
        Map<Integer, Integer> cumulativeSumMap = new HashMap<>();
        int cumulativeSum = 0;

        for (int i = 0; i < numbers.size(); i++) {
            cumulativeSum += numbers.get(i);
            if (cumulativeSum == K) {
                return numbers.subList(0, i + 1);
            }

            int startIdx = cumulativeSumMap.getOrDefault(cumulativeSum - K, -1);
            if (startIdx >= 0) {
                return numbers.subList(startIdx + 1, i + 1);
            }

            cumulativeSumMap.put(cumulativeSum, i);
        }

        return new ArrayList<>();
    }
}
