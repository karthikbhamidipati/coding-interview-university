package dailycodingproblem;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;

public class TwoSumTest {

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private static TwoSum obj;

    @BeforeClass
    public static void setup() {
        obj = new TwoSum();
    }

    @Test
    public void testPositiveCase() {
        int[] arr = {10, 15, 3, 7};
        collector.checkThat("Invalid output", obj.twoSum(arr, 17), equalTo(true));
    }

    @Test
    public void testEmptyInput() {
        int[] arr = {};
        collector.checkThat("Invalid output", obj.twoSum(arr, 17), equalTo(false));
    }

    @Test
    public void testNegativeInput() {
        int[] arr = {10, 15, -3, 7};
        collector.checkThat("Invalid output", obj.twoSum(arr, 12), equalTo(true));
    }

    @Test
    public void testZeroInput() {
        int[] arr = {10, 15, 0, 7};
        collector.checkThat("Invalid output", obj.twoSum(arr, 7), equalTo(true));
    }

}

