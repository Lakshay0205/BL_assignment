package ListInterface;
class LinkedList {
    class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    Node head = null;
    public void add(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
        }
        Node last = head;
        while(last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }

    public int findNthElement(int n) {
        if (head == null || n <= 0) {
            return -1;
        }

        Node fast = head;
        Node slow = head;

        for (int i = 1; i < n; i++) {
            if (fast == null) {
                System.out.println("n is larger than the list size");
                return -1;
            }
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow.data;
    } 
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int element = list.findNthElement(2);

        System.out.println(element);
    
    }

}