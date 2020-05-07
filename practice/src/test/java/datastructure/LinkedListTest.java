package datastructure;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LinkedListTest {
    private static LinkedList<Integer> linkedList;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    public void test1EmptyLinkedList() {
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(0));
        collector.checkThat("LinkedList not empty", linkedList.empty(), equalTo(true));
    }

    @Test
    public void test2PushAndPopFront() {
        for (int i = 10; i >= 0; i--) {
            linkedList.push_front(i);
        }
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(11));
        collector.checkThat("Incorrect LinkedList pop value", linkedList.pop_front(), equalTo(0));
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(10));
    }

    @Test
    public void test3PushAndPopBack() {
        for (int i = 11; i <= 16; i++) {
            linkedList.push_back(i);
        }
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(16));
        collector.checkThat("Incorrect LinkedList pop value", linkedList.pop_back(), equalTo(16));
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(15));
    }

    @Test
    public void test4ValueAt() {
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(10), equalTo(11));
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(15));
    }

    @Test
    public void test5FrontAndBack() {
        collector.checkThat("Incorrect LinkedList value for front", linkedList.front(), equalTo(1));
        collector.checkThat("Incorrect LinkedList value for back", linkedList.back(), equalTo(15));
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(15));
    }

    @Test
    public void test6Insert() {
        linkedList.insert(0, 0);
        linkedList.insert(9, 1000);
        linkedList.insert(17, 10000);
        linkedList.insert(18, 10000);
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(19));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(0), equalTo(0));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(1), equalTo(1));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(8), equalTo(8));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(9), equalTo(1000));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(10), equalTo(9));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(16), equalTo(15));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(17), equalTo(10000));
    }

    @Test
    public void test7Erase() {
        linkedList.erase(0);
        linkedList.erase(8);
        linkedList.erase(15);
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(16));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(0), equalTo(1));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(1), equalTo(2));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(8), equalTo(9));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(9), equalTo(10));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(10), equalTo(11));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(14), equalTo(15));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(15), equalTo(10000));
    }

    @Test
    public void test8ValueNFromEnd() {
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(16));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_n_from_end(1), equalTo(10000));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_n_from_end(2), equalTo(15));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_n_from_end(8), equalTo(9));
    }

    @Test
    public void test9ReverseAndRemoveValue() {
        linkedList.reverse();
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(16));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(0), equalTo(10000));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(1), equalTo(15));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(7), equalTo(9));

        linkedList.remove_value(10000);
        collector.checkThat("Incorrect LinkedList Size", linkedList.size(), equalTo(15));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(0), equalTo(15));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(1), equalTo(14));
        collector.checkThat("Incorrect LinkedList value", linkedList.value_at(7), equalTo(8));
    }

}