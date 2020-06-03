package dailycodingproblem;

import datastructure.util.TreeNode;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import static org.hamcrest.CoreMatchers.equalTo;

public class BSTSerDeTest {
    @Rule
    public ErrorCollector collector = new ErrorCollector();

    private static BSTSerDe obj;
    private static TreeNode<Integer> node;

    @BeforeClass
    public static void setup() {
        obj = new BSTSerDe();
        node = new TreeNode<>(19);
        node.setRight(new TreeNode<>(20));
        TreeNode<Integer> left = new TreeNode<>(15);
        left.setLeft(new TreeNode<>(10));
        left.setRight(new TreeNode<>(17));
        node.setLeft(left);
    }

    @Test
    public void testSerializeDeserialize() {
        TreeNode<Integer> output = obj.deserialize(obj.serialize(node));
        collector.checkThat("Output doesn't match", compareBST(node, output), equalTo(true));

        node.getLeft().getLeft().setLeft(new TreeNode<>(7));
        node.getLeft().getRight().setRight(new TreeNode<>(18));
        output = obj.deserialize(obj.serialize(node));
        collector.checkThat("Output doesn't match", compareBST(node, output), equalTo(true));
    }

    @Test
    public void testEmpty() {
        TreeNode<Integer> output = obj.deserialize(obj.serialize(null));
        collector.checkThat("Output doesn't match", compareBST(null, output), equalTo(true));
    }

    @Test
    public void testSingleLevel() {
        TreeNode<Integer> node = new TreeNode<>(19);
        TreeNode<Integer> output = obj.deserialize(obj.serialize(node));
        collector.checkThat("Output doesn't match", compareBST(node, output), equalTo(true));
    }

    @Test
    public void testInvalidDeserialize() {
        TreeNode<Integer> output = obj.deserialize("");
        collector.checkThat("Output doesn't match", compareBST(null, output), equalTo(true));
        output = obj.deserialize("abc");
        collector.checkThat("Output doesn't match", compareBST(null, output), equalTo(true));
        output = obj.deserialize("n:");
        collector.checkThat("Output doesn't match", compareBST(null, output), equalTo(true));
    }

    private boolean compareBST(TreeNode<Integer> node, TreeNode<Integer> output) {
        if (node == null && output == null) {
            return true;
        }

        if (node == null || output == null || !node.getData().equals(output.getData())) {
            return false;
        }

        return compareBST(node.getLeft(), output.getLeft()) && compareBST(node.getRight(), output.getRight());
    }
}
