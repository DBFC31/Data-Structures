package dataStructures;

public class BST {

    public Node root;

    public class Node {
        public int value;
        public Node left, right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        insert(root, value);
    }

    private void insert(Node cur, int value) {
        if (value == cur.value)
            return;

        Node n = new Node(value);
        if (value < cur.value) {
            if (cur.left == null) {
                cur.left = n;
                return;
            }
            insert(cur.left, value);
        } else {
            if (cur.right == null) {
                cur.right = n;
                return;
            }
            insert(cur.right, value);
        }
    }

    public boolean contains(int value) {
        if (root == null)
            return false;
        return contains(root, value);
    }

    public boolean contains(Node cur, int value) {
        if (cur == null)
            return false;
        if (value == cur.value)
            return true;
        if (value < cur.value)
            return contains(cur.left, value);
        return contains(cur.right, value);
    }

    public int minValue(Node cur) {
        while (cur.left != null) {
            cur = cur.left;
        }
        return cur.value;
    }

    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node cur, int value) {
        if (root == null)
            return null;

        if (value < cur.value) {
            cur.left = deleteNode(cur.left, value);
        } else if (value > cur.value) {
            cur.right = deleteNode(cur.right, value);
        } else {
            if (cur.left == null && cur.right == null) {
                return null;
            } else if (cur.left == null) {
                return cur.right;
            } else if (cur.right == null) {
                return cur.left;
            } else {
                int minValue = minValue(cur.right);
                cur.value = minValue;
                cur.right = deleteNode(cur.right, minValue);
            }
        }
        return cur;
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null)
            return;

        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        BST t = new BST();
        t.insert(37);
        t.insert(66);
        t.insert(42);
        t.insert(11);
        t.insert(72);
        t.insert(8);
        t.insert(17);
        t.deleteNode(66);
        t.inOrder();
    }
}