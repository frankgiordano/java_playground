package playground;

/**
 * Used this circular double linked list to implement a command history list for the following project
 * https://github.com/frankgiordano/ZosShell
 */
public class CircularLinkedList<T> {

    public static class Node<T> {
        public final T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    private int max = 500;
    public int size = 0;
    public Node<T> head = null;
    public Node<T> tail = null;
    public Node<T> currNode = null;

    public CircularLinkedList(int max) {
        this.max = max;
    }

    public CircularLinkedList() {
    }

    // this function will add the new node at the end of the list
    public void add(T data) {
        // create new node
        Node<T> newNode = new Node<>(data);

        if (size == max) {
            // set the new head pointer
            head = head.next;
            setTail(newNode);
            return;
        }

        // checks if the list is empty
        if (head == null) {
            // if list is empty, head, prev and tail would point to new node
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            setTail(newNode);
        }
        size++;
    }

    public T forward() {
        if (currNode == null) {
            currNode = this.head;
        } else {
            currNode = currNode.next;
        }
        return currNode.data;
    }

    public T back() {
        T result;
        if (currNode == null) {
            currNode = this.tail;
            result = currNode.data;
            return result;
        }

        currNode = currNode.prev;
        result = currNode.data;
        return result;
    }

    // displays all the nodes in the list
    public void display() {
        Node<T> current = head;
        if (head == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                // prints each node by incrementing pointer.
                System.out.print(" " + current.data);
                current = current.next;
            } while (current != head);
            System.out.println();
        }
    }

    public void displayReverse() {
        Node<T> current = tail;
        if (tail == null) {
            System.out.println("List is empty");
        } else {
            System.out.println("Nodes of the circular linked list: ");
            do {
                // prints each node by incrementing pointer.
                System.out.print(" " + current.data);
                current = current.prev;
            } while (current != head.prev);
            System.out.println();
        }
    }

    private void setTail(Node<T> newNode) {
        // tail will point to new node
        tail.next = newNode;
        // hold a temp reference to current tail node
        var temp = tail;
        // new node will become new tail
        tail = newNode;
        // circular tail will point to new head
        tail.next = head;
        // link to previous tail node
        tail.prev = temp;
        // circular double linked
        head.prev = tail;
    }

    // Helper to fill list with values from zero to size...
    private void fillList(CircularLinkedList<Integer> cl, int size) {
        for (int i = 0; i < size; i++)
            cl.add(i);
    }

    public static void main(String[] args) {
        CircularLinkedList<Integer> cl = new CircularLinkedList<>();

        cl.fillList(cl, 10);
        cl.display();
        cl.displayReverse();

        cl = new CircularLinkedList<>(5);

        cl.fillList(cl, 7);
        cl.display();
        cl.displayReverse();
    }

}
