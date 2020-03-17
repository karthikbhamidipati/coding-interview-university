import datastructure.array.Vector;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VectorTest {
    private static Vector<Integer> vector1;
    private static Vector<Integer> vector2;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        vector1 = new Vector<>();
        vector2 = new Vector<>(16);
    }

    @Test
    public void test1EmptyVector() {
        collector.checkThat("Incorrect vector1 size", vector1.size(), equalTo(0));
        collector.checkThat("Incorrect vector2 size", vector2.size(), equalTo(0));
        collector.checkThat("Incorrect vector1 capacity", vector1.capacity(), equalTo(2));
        collector.checkThat("Incorrect vector2 capacity", vector2.capacity(), equalTo(16));
        collector.checkThrows(ArrayIndexOutOfBoundsException.class, () -> vector1.at(2));
        collector.checkThrows(ArrayIndexOutOfBoundsException.class, () -> vector2.at(2));
        collector.checkThat("Vector1 not empty", vector1.isEmpty(), equalTo(true));
        collector.checkThat("Vector2 not empty", vector2.isEmpty(), equalTo(true));
    }

    @Test
    public void test2PushItem() {
        for (int i = 1; i <= 10; i++) {
            vector1.push(i);
        }
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(10));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));
        for (int i = 1; i <= 100; i++) {
            vector2.push(i);
        }
        collector.checkThat("Incorrect Vector1 size", vector2.size(), equalTo(100));
        collector.checkThat("Incorrect Vector1 capacity", vector2.capacity(), equalTo(128));
    }

    @Test
    public void test3InsertItem() {
        vector1.insert(3, 5);
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(11));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));
        collector.checkThat("Incorrect value", vector1.at(3), equalTo(5));
        collector.checkThat("Incorrect value", vector1.at(4), equalTo(4));
        collector.checkThat("Incorrect value", vector1.at(2), equalTo(3));
        vector2.insert(6, 10);
        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(101));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(128));
        collector.checkThat("Incorrect value", vector2.at(6), equalTo(10));
        collector.checkThat("Incorrect value", vector2.at(7), equalTo(7));
        collector.checkThat("Incorrect value", vector2.at(5), equalTo(6));
    }

    @Test
    public void test4PrependItem() {
        vector1.prepend(0);
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(12));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));
        collector.checkThat("Incorrect value", vector1.at(0), equalTo(0));
        collector.checkThat("Incorrect value", vector1.at(1), equalTo(1));
        vector2.prepend(0);
        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(102));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(128));
        collector.checkThat("Incorrect value", vector2.at(0), equalTo(0));
        collector.checkThat("Incorrect value", vector2.at(1), equalTo(1));
    }

    @Test
    public void test5PopItem() {
        collector.checkThat("Incorrect value", vector1.pop(), equalTo(10));
        collector.checkThat("Incorrect value", vector1.pop(), equalTo(9));
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(10));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));

        collector.checkThat("Incorrect value", vector2.pop(), equalTo(100));
        collector.checkThat("Incorrect value", vector2.pop(), equalTo(99));
        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(100));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(128));

        int limit = (vector2.capacity() / 4);

        for (int i = vector2.size() - 1; i >= limit; i--) {
            vector2.pop();
        }

        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(32));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(64));
    }

    @Test
    public void test6DeleteItem() {
        vector1.delete(0);
        vector1.delete(2);
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(8));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));
        collector.checkThat("Incorrect value", vector1.at(0), equalTo(1));
        collector.checkThat("Incorrect value", vector1.at(1), equalTo(2));
        collector.checkThat("Incorrect value", vector1.at(2), equalTo(5));

        vector2.delete(0);
        vector2.delete(2);
        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(30));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(64));
        collector.checkThat("Incorrect value", vector2.at(0), equalTo(1));
        collector.checkThat("Incorrect value", vector2.at(1), equalTo(2));
        collector.checkThat("Incorrect value", vector2.at(2), equalTo(4));
    }

    @Test
    public void test7RemoveItem() {
        vector1.remove(5);
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(6));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));
        collector.checkThat("Incorrect value", vector1.at(1), equalTo(2));
        collector.checkThat("Incorrect value", vector1.at(2), equalTo(4));
        collector.checkThat("Incorrect value", vector1.at(3), equalTo(6));
        collector.checkThat("Incorrect value", vector1.at(4), equalTo(7));

        vector2.remove(10);
        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(28));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(64));
        collector.checkThat("Incorrect value", vector2.at(4), equalTo(6));
        collector.checkThat("Incorrect value", vector2.at(5), equalTo(7));
        collector.checkThat("Incorrect value", vector2.at(6), equalTo(8));
        collector.checkThat("Incorrect value", vector2.at(7), equalTo(9));
        collector.checkThat("Incorrect value", vector2.at(8), equalTo(11));
        collector.checkThat("Incorrect value", vector2.at(9), equalTo(12));
    }

    @Test
    public void test8FindItem() {
        collector.checkThat("Incorrect Vector1 size", vector1.size(), equalTo(6));
        collector.checkThat("Incorrect Vector1 capacity", vector1.capacity(), equalTo(16));
        collector.checkThat("Incorrect value", vector1.find(2), equalTo(1));
        collector.checkThat("Incorrect value", vector1.find(4), equalTo(2));
        collector.checkThat("Incorrect value", vector1.find(5), equalTo(-1));

        collector.checkThat("Incorrect Vector2 size", vector2.size(), equalTo(28));
        collector.checkThat("Incorrect Vector2 capacity", vector2.capacity(), equalTo(64));
        collector.checkThat("Incorrect value", vector2.find(6), equalTo(4));
        collector.checkThat("Incorrect value", vector2.find(7), equalTo(5));
        collector.checkThat("Incorrect value", vector2.find(10), equalTo(-1));
    }

}
