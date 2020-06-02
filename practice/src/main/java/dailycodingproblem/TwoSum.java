package dailycodingproblem;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
 *
 * For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17
 */
public class TwoSum {
    public boolean twoSum(int[] array, int k) {
        Set<Integer> diffSet = new HashSet<>();
        for (int value : array) {
            if (diffSet.contains(value)) {
                return true;
            } else {
                diffSet.add(k - value);
            }
        }
        return false;
    }
}
