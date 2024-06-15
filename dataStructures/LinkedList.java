package dataStructures;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList(String data) {
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void append(String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void prepend(String data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        length++;

        if (length == 1) {
            tail = newNode;
        }
    }

    public boolean insert(int index, String data) {
        if (index < 0 || index > length) {
            System.out.println("Index out of bounds");
            return false;
        }

        if (index == 0) {
            prepend(data);
            return true;
        }
        if (index == length) {
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node n = get(index - 1);
        newNode.next = n.next;
        n.next = newNode;
        length++;
        return true;
    }

    public Node removeFirst() {
        if (length == 0)
            return null;

        Node r = head;
        if (length == 1) {
            this.MakeEmpty();
            return r;
        }

        head = head.next;
        r.next = null;
        length--;
        return r;
    }

    public Node removeLast() {
        if (length == 0)
            return null;
        Node r;
        Node cur = head;
        while (cur.next != tail) {
            cur = cur.next;
        }
        r = cur.next;
        cur.next = null;
        tail = cur;
        length--;
        if (length == 0) {
            this.MakeEmpty();
        }
        return r;
    }

    public Node removeIndex(int index) {
        if (length == 0) {
            return null;
        }
        if (index < 0 || index >= length) {
            System.out.println("Index out of bounds");
            return null;
        }

        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }

        Node prev = get(index - 1);
        Node r = prev.next;
        prev.next = r.next;
        r.next = null;
        length--;
        if (length == 0) {
            MakeEmpty();
        }
        return r;
    }

    public void print() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public Node get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Index out of bounds");
            return null;
        }

        Node cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public boolean set(int index, String data) {
        Node n = get(index); // if the index is out of bounds, n will be null
        if (n == null) {
            return false;
        }
        n.data = data;
        return true;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void MakeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public static void main(String[] args) {
        LinkedList teste = new LinkedList("elemento 1");
        teste.append("elemento 3");
        teste.append("elemento 4");
        teste.prepend("elemento 0");
        teste.insert(2, "elemento 2");
        teste.removeIndex(2);
        teste.insert(2, "elmento 2");
        teste.set(2, "elemento 2");
        System.out.println(teste.getHead().data);
        System.out.println(teste.getTail().data);
        System.out.println(teste.getLength());
        teste.print();

        System.out.println(teste.get(1).data);
    }
}