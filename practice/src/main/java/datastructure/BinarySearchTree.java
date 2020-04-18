package datastructure;

import datastructure.util.BTreePrinter;
import datastructure.util.TreeNode;

public class BinarySearchTree<E extends Comparable<? super E>> {

    private TreeNode<E> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public void insert(E data) {
        if (this.root == null) {
            this.root = new TreeNode<>(data);
        } else {
            this.traverseAndInsert(this.root, data);
        }
    }

    private void traverseAndInsert(TreeNode<E> node, E data) {
        if (data.compareTo(node.getData()) < 0) {
            if (node.getLeft() == null) {
                node.setLeft(new TreeNode<>(data));
            } else {
                traverseAndInsert(node.getLeft(), data);
            }
        } else if (data.compareTo(node.getData()) > 0) {
            if (node.getRight() == null) {
                node.setRight(new TreeNode<>(data));
            } else {
                traverseAndInsert(node.getRight(), data);
            }
        }
    }

    public int getNodeCount() {
        return this.count(this.root);
    }

    private int count(TreeNode<E> node) {
        if (node == null) {
            return 0;
        } else {
            return count(node.getLeft()) + count(node.getRight()) + 1;
        }
    }

    public void printValues() {
        StringBuilder sb = new StringBuilder();
        this.inOrderTraversal(this.root, sb);
        System.out.println(sb.toString().trim());
        BTreePrinter.printNode(this.root);
    }

    private void inOrderTraversal(TreeNode<E> node, StringBuilder sb) {
        if (node.getLeft() != null) {
            inOrderTraversal(node.getLeft(), sb);
        }

        sb.append(node.getData().toString());
        sb.append(" ");

        if (node.getRight() != null) {
            inOrderTraversal(node.getRight(), sb);
        }
    }

    public void deleteTree() {
        this.root = null;
    }

    public boolean isInTree(E data) {
        return this.getNode(this.root, data) != null;
    }

    private TreeNode<E> getNode(TreeNode<E> node, E data) {
        if (node == null) {
            return null;
        } else if (data.compareTo(node.getData()) < 0) {
            return this.getNode(node.getLeft(), data);
        } else if (data.compareTo(node.getData()) > 0) {
            return this.getNode(node.getRight(), data);
        } else {
            return node;
        }
    }

    public int getHeight() {
        return this.root == null ? 0 : this.height(this.root);
    }

    private int height(TreeNode<E> node) {
        if (node == null) {
            return -1;
        } else {
            return Math.max(height(node.getRight()) + 1, height(node.getLeft()) + 1);
        }
    }

    public E getMin() {
        if (this.root == null) {
            return null;
        }
        return leftMostNode(this.root).getData();
    }

    private TreeNode<E> leftMostNode(TreeNode<E> node) {
        if (node.getLeft() == null) {
            return node;
        } else {
            return leftMostNode(node.getLeft());
        }
    }

    public E getMax() {
        if (this.root == null) {
            return null;
        }
        return rightMostNode(this.root).getData();
    }

    private TreeNode<E> rightMostNode(TreeNode<E> node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return rightMostNode(node.getRight());
        }
    }

    public boolean isBST(E minValue, E maxValue) {
        return checkBST(this.root, minValue, maxValue);
    }

    private boolean checkBST(TreeNode<E> node, E start, E end) {
        if (node == null) {
            return true;
        } else if (start.compareTo(node.getData()) < 0 && end.compareTo(node.getData()) > 0) {
            return checkBST(node.getLeft(), start, node.getData()) && checkBST(node.getRight(), node.getData(), end);
        } else {
            return false;
        }
    }

    public void deleteValue(E value) {
        this.root = deleteValue(this.root, value);
    }

    private TreeNode<E> deleteValue(TreeNode<E> node, E value) {
        if (node == null) {
            return null;
        }

        if (value.compareTo(node.getData()) < 0) {
            node.setLeft(deleteValue(node.getLeft(), value));
        } else if (value.compareTo(node.getData()) > 0) {
            node.setRight(deleteValue(node.getRight(), value));
        } else {
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }

            node.setData(leftMostNode(node.getRight()).getData());
            node.setRight(deleteValue(node.getRight(), node.getData()));
        }

        return node;
    }

    public E getSuccessor(E value) {
        if (this.root == null)
            return null;

        TreeNode<E> successor = null;
        TreeNode<E> node = this.root;

        while (node.getData() != value) {
            if (value.compareTo(node.getData()) < 0) {
                successor = node;
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }

        if (node.getRight() == null) {
            return successor != null ? successor.getData() : null;
        } else {
            return leftMostNode(node.getRight()).getData();
        }
    }

}
