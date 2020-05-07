package datastructure;


import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QueueTest {

    private static Queue<Integer> queueUsingLinkedList;
    private static QueueUsingArrays<Integer> queueUsingArrays1;
    private static QueueUsingArrays<Integer> queueUsingArrays2;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        queueUsingLinkedList = new QueueUsingLinkedList<>();
        queueUsingArrays1 = new QueueUsingArrays<>();
        queueUsingArrays2 = new QueueUsingArrays<>(5);
    }

    @Test
    public void test1LinkedListEnqueueDequeue() {
        collector.checkThat("Queue not empty", queueUsingLinkedList.empty(), equalTo(true));

        queueUsingLinkedList.enqueue(1);
        queueUsingLinkedList.enqueue(2);
        queueUsingLinkedList.enqueue(3);
        queueUsingLinkedList.enqueue(4);

        collector.checkThat("Queue should not be empty", queueUsingLinkedList.empty(), equalTo(false));

        collector.checkThat("Incorrect value", queueUsingLinkedList.dequeue(), equalTo(1));
        collector.checkThat("Incorrect value", queueUsingLinkedList.dequeue(), equalTo(2));

        collector.checkThat("Queue should not be empty", queueUsingLinkedList.empty(), equalTo(false));

        collector.checkThat("Incorrect value", queueUsingLinkedList.dequeue(), equalTo(3));
        collector.checkThat("Incorrect value", queueUsingLinkedList.dequeue(), equalTo(4));

        collector.checkThat("Queue not empty", queueUsingLinkedList.empty(), equalTo(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test2LinkedListDequeEmpty() {
        collector.checkThat("Queue not empty", queueUsingLinkedList.empty(), equalTo(true));

        collector.checkThat("Incorrect value", queueUsingLinkedList.dequeue(), equalTo(4));

        collector.checkThat("Queue not empty", queueUsingLinkedList.empty(), equalTo(true));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test3ArraysEnqueueDequeue() {
        collector.checkThat("Queue not empty", queueUsingArrays1.empty(), equalTo(true));
        collector.checkThat("Queue not empty", queueUsingArrays2.empty(), equalTo(true));

        for (int i = 1; i < 5 ; i++) {
            queueUsingArrays1.enqueue(i);
            queueUsingArrays2.enqueue(i);
        }

        collector.checkThat("Queue should not be empty", queueUsingArrays1.empty(), equalTo(false));
        collector.checkThat("Queue should not be empty", queueUsingArrays2.empty(), equalTo(false));
        collector.checkThat("Queue should not be full", queueUsingArrays1.full(), equalTo(false));
        collector.checkThat("Queue should be full", queueUsingArrays2.full(), equalTo(true));

        collector.checkThat("Incorrect value", queueUsingArrays2.dequeue(), equalTo(1));
        collector.checkThat("Incorrect value", queueUsingArrays2.dequeue(), equalTo(2));
        collector.checkThat("Incorrect value", queueUsingArrays2.dequeue(), equalTo(3));
        collector.checkThat("Incorrect value", queueUsingArrays2.dequeue(), equalTo(4));

        collector.checkThat("Queue not empty", queueUsingArrays2.empty(), equalTo(true));
        queueUsingArrays2.dequeue();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void test4ArraysDequeueFull() {
        for (int i = 5; i < 11 ; i++) {
            queueUsingArrays1.enqueue(i);
        }
    }

    @Test
    public void test5ArraysEnqueueDequeue() {
        collector.checkThat("Queue should be full", queueUsingArrays1.full(), equalTo(true));
        collector.checkThat("Incorrect value", queueUsingArrays1.dequeue(), equalTo(1));

        queueUsingArrays1.enqueue(11);
        collector.checkThat("Incorrect value", queueUsingArrays1.dequeue(), equalTo(2));

        queueUsingArrays1.enqueue(12);
        collector.checkThat("Incorrect value", queueUsingArrays1.dequeue(), equalTo(3));

    }

}