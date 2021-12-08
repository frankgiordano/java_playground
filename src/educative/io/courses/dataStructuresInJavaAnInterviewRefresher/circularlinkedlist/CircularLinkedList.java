package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.circularlinkedlist;

public class CircularLinkedList<T> {

    public static class Node<T> {
        final T data;
        Node<T> next;
        Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public Node<T> head = null;
    public Node<T> tail = null;
    public Node<T> currNode = null;

    // this function will add the new node at the end of the list.
    public void add(T data) {
        // create new node
        Node<T> newNode = new Node<>(data);
        // checks if the list is empty.
        if (head == null) {
            // if list is empty, head, prev and tail would point to new node.
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            // tail will point to new node.
            tail.next = newNode;
            // hold a temp reference to current tail node
            var temp = tail;
            // new node will become new tail.
            tail = newNode;
            // since, it is circular linked list tail will point to head.
            tail.next = head;
            // link to previous tail node
            tail.prev = temp;
            // circular double linked
            head.prev = tail;
        }
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
        Node current = head;
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
        Node current = tail;
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

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList<Integer>();

        cl.add(1);
        cl.add(2);
        cl.add(3);
        cl.add(4);
        cl.add(5);
        cl.add(6);
        cl.add(7);

        cl.display();
        cl.displayReverse();

        System.out.println(cl.forward());
        System.out.println(cl.forward());
        System.out.println(cl.forward());
        System.out.println(cl.forward());
        System.out.println(cl.back());
        System.out.println(cl.back());
        System.out.println(cl.back());
        System.out.println(cl.back());
        System.out.println(cl.back());
        System.out.println(cl.back());
        System.out.println(cl.back());
        System.out.println(cl.back());
    }

}
