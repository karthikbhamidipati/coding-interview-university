package dailycodingproblem;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;


public class CumulativeSumTest {
    private static CumulativeSum obj;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setup() {
        obj = new CumulativeSum();
    }

    @Test
    public void test() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        collector.checkThat(obj.getSubList(numbers, 0), equalTo(Collections.EMPTY_LIST));
        collector.checkThat(obj.getSubList(numbers, 1), equalTo(Collections.singletonList(1)));
        collector.checkThat(obj.getSubList(numbers, 6), equalTo(Arrays.asList(1, 2, 3)));
        collector.checkThat(obj.getSubList(numbers, 9), equalTo(Arrays.asList(2, 3, 4)));
        collector.checkThat(obj.getSubList(numbers, 12), equalTo(Arrays.asList(3, 4, 5)));
    }
}
