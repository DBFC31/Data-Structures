package dataStructures;

public class Queue {

    class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node first, last;
    int length;

    public Queue(int data) {
        Node n = new Node(data);
        first = n;
        last = n;
        length = 1;
    }

    public void enqueue(int data) {
        if (length == 0) {
            Node n = new Node(data);
            first = n;
            last = n;
            length++;
            return;
        }

        Node n = new Node(data);
        last.next = n;
        last = n;
        length++;
        return;
    }

    public Node dequeue() {
        if (length == 0)
            return null;

        Node r = first;

        if (length == 1) {
            last = null;
            first = null;
            length--;
            return r;
        }

        first = first.next;
        r.next = null;
        length++;
        return r;
    }

    public void print() {
        Node cur = first;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public int getLength() {
        return length;
    }

    public static void main(String[] args) {
        Queue teste = new Queue(1);
        teste.dequeue();
        int[] numbers = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        for (int i = 0; i < numbers.length; i++) {
            teste.enqueue(numbers[i]);
        }
        teste.dequeue();
        teste.dequeue();
        teste.print();
    }
}
