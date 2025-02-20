package ListInterface;

class Node<T> {
    T data;
    Node<T> next;


    Node(T data) {
        this.data = data;
        this.next = null;
    }
}


class LinkedList<T> {
    Node<T> head;


    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }


    public void rotate(int k) {
        if (head == null || k == 0) {
            return;
        }


        int size = 0;
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
            size++;
        }
        size++;


        k = k % size;
        if (k == 0) return;


        if (k < 0) {
            k = size + k;
        }


        Node<T> current = head;
        for (int i = 1; i < size - k; i++) {
            current = current.next;
        }


        tail.next = head;
        head = current.next;
        current.next = null;
    }


    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);


        System.out.println("Original list:");
        list.printList();


        list.rotate(2);
        System.out.println("Rotated list (2 positions):");
        list.printList();


        list = new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);


        list.rotate(-1);
        System.out.println("Rotated list (-1 position):");
        list.printList();
    }
}
