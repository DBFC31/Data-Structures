package dataStructures;

import java.util.Queue;
import java.util.LinkedList;

public class Tree {

    public Node root;

    public static class Node {
        public int value;
        public Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
        }
    }

    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Node cur = queue.remove();
            if (cur.left == null) {
                cur.left = newNode;
                break;
            } else {
                queue.add(cur.left);
            }
            if (cur.right == null) {
                cur.right = newNode;
                break;
            } else {
                queue.add(cur.right);
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node node) {
        // root, left, right

        if (node == null)
            return;

        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        // left, root, right

        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public void posOrder() {
        posOrder(root);
    }

    private void posOrder(Node node) {
        // left, right, root

        if (node == null)
            return;

        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);
    }

    public void BFS() {
        if (root == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();

            if (node.left != null)
                queue.add(node.left);
            if (node.right != null)
                queue.add(node.right);

            System.out.println(node.value);
        }
    }

    public void DFS() {
        preOrder();
    }

    public static void main(String[] args) {
        Tree t = new Tree();
        t.insert(1);
        t.insert(2);
        t.insert(3);

        System.out.println(t.root.value);
        System.out.println(t.root.left.value);
        System.out.println(t.root.right.value);
        System.out.println(t.root.isLeaf());
        System.out.println(t.root.left.isLeaf());
        System.out.println(t.root.right.isLeaf());
    }
}
