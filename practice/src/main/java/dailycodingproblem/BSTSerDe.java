package dailycodingproblem;

import datastructure.util.TreeNode;

/**
 * Given the root to a binary tree
 * Implement:
 * serialize(root) -> which serializes the tree into a string
 * deserialize(s) -> which deserializes the string back into the tree
 */
public class BSTSerDe {

    private int index;

    public String serialize(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        preOrderTraversalSerialize(root, sb);
        return sb.toString();
    }

    private void preOrderTraversalSerialize(TreeNode<Integer> node, StringBuilder sb) {
        sb.append(node.getData().toString());

        if (node.getLeft() == null) {
            sb.append(" null");
        } else {
            sb.append(" ");
            preOrderTraversalSerialize(node.getLeft(), sb);
        }
        if (node.getRight() == null) {
            sb.append(" null");
        } else {
            sb.append(" ");
            preOrderTraversalSerialize(node.getRight(), sb);
        }
    }

    public TreeNode<Integer> deserialize(String s) {
        index = 0;
        return preOrderTraversalDeserialize(s);
    }

    private TreeNode<Integer> preOrderTraversalDeserialize(String s) {
        if (s == null || s.length() == 0 || index >= s.length()) {
            return null;
        }
        int num = 0;

        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            num = (num * 10) + (s.charAt(index) - '0');
            index++;
        }

        index++;
        TreeNode<Integer> node = new TreeNode<>(num);
        if (s.startsWith("null", index)) {
            node.setLeft(null);
            index += 4;
        } else {
            node.setLeft(preOrderTraversalDeserialize(s));
        }

        index++;
        if (s.startsWith("null", index)) {
            node.setRight(null);
            index += 4;
        } else {
            node.setRight(preOrderTraversalDeserialize(s));
        }
        return node;
    }
}
