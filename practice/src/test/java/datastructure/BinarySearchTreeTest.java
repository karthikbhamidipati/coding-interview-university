package datastructure;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runners.MethodSorters;

import java.util.Random;

import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BinarySearchTreeTest {

    private static BinarySearchTree<Integer> binarySearchTree;

    @Rule
    public ErrorCollector collector = new ErrorCollector();

    @BeforeClass
    public static void setUp() {
        binarySearchTree = new BinarySearchTree<>();
    }

    @Test
    public void test1EmptyBST() {
        collector.checkThat("BST not empty", binarySearchTree.getNodeCount(), equalTo(0));
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));
    }

    @Test
    public void test2Inserts() {
        insertRandomValues(0, 100, 5);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));
        collector.checkThat("BST size mismatch", binarySearchTree.getNodeCount(), equalTo(5));
        insertRandomValues(40, 150, 30);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));
        collector.checkThat("BST size mismatch", binarySearchTree.getNodeCount(), equalTo(35));
    }

    @Test
    public void test3DeleteAndInsertInTree() {
        binarySearchTree.deleteTree();
        binarySearchTree.deleteValue(1);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));
        collector.checkThat("Invalid Successor", binarySearchTree.getSuccessor(71), equalTo(null));
        collector.checkThat("BST size mismatch", binarySearchTree.getNodeCount(), equalTo(0));
        collector.checkThat("Tree Not Deleted", binarySearchTree.getMin(), equalTo(null));
        collector.checkThat("Tree Not Deleted", binarySearchTree.getMax(), equalTo(null));
        insertValuesInTree();
        collector.checkThat("BST size mismatch", binarySearchTree.getNodeCount(), equalTo(18));
    }

    @Test
    public void test4PresentInTreeAndHeight() {
        collector.checkThat("BST Node should be present", binarySearchTree.isInTree(49), equalTo(true));
        collector.checkThat("BST Node should be present", binarySearchTree.isInTree(45), equalTo(true));
        collector.checkThat("BST Node should be present", binarySearchTree.isInTree(85), equalTo(true));
        collector.checkThat("BST Node should be present", binarySearchTree.isInTree(75), equalTo(true));
        collector.checkThat("BST Node should be present", binarySearchTree.isInTree(65), equalTo(true));

        collector.checkThat("BST height mismatch", binarySearchTree.getHeight(), equalTo(5));
    }

    @Test
    public void test5getMinAndMax() {
        collector.checkThat("BST Node should be present", binarySearchTree.getMin(), equalTo(30));
        collector.checkThat("BST Node should be present", binarySearchTree.getMax(), equalTo(85));
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));
    }

    @Test
    public void test6GetSuccessorDelete() {
        collector.checkThat("Invalid Successor", binarySearchTree.getSuccessor(71), equalTo(73));
        collector.checkThat("Invalid Successor", binarySearchTree.getSuccessor(74), equalTo(75));
        collector.checkThat("Invalid Successor", binarySearchTree.getSuccessor(49), equalTo(50));
        collector.checkThat("Invalid Successor", binarySearchTree.getSuccessor(80), equalTo(85));
        binarySearchTree.printValues();

        binarySearchTree.deleteValue(75);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));

        binarySearchTree.deleteValue(80);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));

        binarySearchTree.deleteValue(65);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));

        binarySearchTree.deleteValue(74);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));

        binarySearchTree.deleteValue(71);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));

        binarySearchTree.deleteValue(50);
        collector.checkThat("Invalid BST", binarySearchTree.isBST(Integer.MIN_VALUE, Integer.MAX_VALUE), equalTo(true));

        binarySearchTree.printValues();

    }

    private void insertValuesInTree() {
        binarySearchTree.insert(75);
        binarySearchTree.insert(65);
        binarySearchTree.insert(80);
        binarySearchTree.insert(60);
        binarySearchTree.insert(70);
        binarySearchTree.insert(85);
        binarySearchTree.insert(79);
        binarySearchTree.insert(44);
        binarySearchTree.insert(64);
        binarySearchTree.insert(30);
        binarySearchTree.insert(49);
        binarySearchTree.insert(61);
        binarySearchTree.insert(45);
        binarySearchTree.insert(50);
        binarySearchTree.insert(62);
        binarySearchTree.insert(74);
        binarySearchTree.insert(71);
        binarySearchTree.insert(73);
    }

    private void insertRandomValues(int start, int end, int count) {
        Random random = new Random();
        while (count-- > 0) {
            int value = random.nextInt((end - start) + 1) + start;
            if (binarySearchTree.isInTree(value)) {
                count++;
            } else {
                binarySearchTree.insert(value);
            }
        }
    }

}
