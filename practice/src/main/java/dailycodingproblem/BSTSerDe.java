package dailycodingproblem;

import datastructure.util.TreeNode;

/**
 * Given the root to a binary tree
 * Implement:
 *  serialize(root) -> which serializes the tree into a string
 *  deserialize(s) -> which deserializes the string back into the tree
 */
public class BSTSerDe {

    private int index;

    public String serialize(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        preOrderTraversalSerialize(root, sb);
        sb.delete(sb.length() - 2, sb.length() - 1);
        return sb.toString();
    }

    private void preOrderTraversalSerialize(TreeNode<Integer> node, StringBuilder sb) {
        sb.append("n: ");
        sb.append(node.getData().toString());
        sb.append(", ");

        if (node.getLeft() == null) {
            sb.append("l: null, ");
        } else {
            sb.append("l: ");
            preOrderTraversalSerialize(node.getLeft(), sb);
        }
        if (node.getRight() == null) {
            sb.append("r: null, ");
        } else {
            sb.append("r: ");
            preOrderTraversalSerialize(node.getRight(), sb);
        }
    }

    public TreeNode<Integer> deserialize(String s) {
        if (s == null) {
            return null;
        }
        index = 0;
        return preOrderTraversalDeserialize(s);
    }

    private TreeNode<Integer> preOrderTraversalDeserialize(String s) {
        if (index >= s.length() - 3 || !s.startsWith("n:", index)) {
            return null;
        }
        index += 3;
        int num = 0;

        while (Character.isDigit(s.charAt(index))) {
            num = (num * 10) + (s.charAt(index) - '0');
            index++;
        }

        index += 5;
        TreeNode<Integer> node = new TreeNode<>(num);
        if (s.startsWith("null", index)) {
            node.setLeft(null);
            index += 4;
        } else {
            node.setLeft(preOrderTraversalDeserialize(s));
        }

        index += 5;
        if (s.startsWith("null", index)) {
            node.setRight(null);
            index += 4;
        } else {
            node.setRight(preOrderTraversalDeserialize(s));
        }
        return node;
    }
}
