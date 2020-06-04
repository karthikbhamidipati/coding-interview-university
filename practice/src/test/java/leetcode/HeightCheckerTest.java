package leetcode;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;

public class HeightCheckerTest {
    private static HeightChecker obj;
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setup() {
        obj = new HeightChecker();
    }

    @Test
    public void testUnsortedArray() {
        int[] arr = {1, 1, 4, 2, 1, 3};
        collector.checkThat("Invalid swaps for Array : " + Arrays.toString(arr), obj.heightChecker(arr), equalTo(3));
    }

    @Test
    public void testSortedArray() {
        int[] arr = {1, 1, 2, 3, 4};
        collector.checkThat("Invalid swaps for Array : " + Arrays.toString(arr), obj.heightChecker(arr), equalTo(0));
    }

    @Test
    public void testReversedArray() {
        int[] arr = {5, 4, 3, 3, 2, 1};
        collector.checkThat("Invalid swaps for Array : " + Arrays.toString(arr), obj.heightChecker(arr), equalTo(4));
    }

    @Test
    public void testUnsortedArray2() {
        int[] arr = {5, 1, 2, 3, 4};
        collector.checkThat("Invalid swaps for Array : " + Arrays.toString(arr), obj.heightChecker(arr), equalTo(5));
    }
}
