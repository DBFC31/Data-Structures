package dataStructures;

public class Stack {

    private Node top;
    private int height;

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public Stack(int data) {
        height = 1;
        top = new Node(data);
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop() {
        if (height == 0)
            return null;

        Node temp = top;
        top = top.next;
        height--;
        return temp;
    }

    public Node getTop() {
        return top;
    }

    public int getHeight() {
        return height;
    }

    public void print() {
        Node cur = top;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public static void main(String[] args) { // invert an array of integers
        Stack teste = new Stack(1);
        teste.pop();
        int[] numbers = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        for (int i = 0; i < numbers.length; i++) {
            teste.push(numbers[i]);
        }

        teste.print();
    }
}