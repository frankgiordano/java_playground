package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist;

public class LinkedList {

    public Node headNode;

    // Constructor - Initializing Head Node
    public LinkedList() {
        headNode = new Node();
    }

    // Helper Function that checks if List is empty or not
    public boolean isEmpty() {

        if (headNode.nextElement == null)
            return true;
        return false;
    }

    // Helper Function to printList
    public boolean printList() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return false;
        }

        Node temp = headNode.nextElement;
        System.out.print("List : ");

        while (temp.nextElement != null) {
            System.out.print(temp.data + "->");
            temp = temp.nextElement;
        }

        System.out.println(temp.data + "->null");
        return true;
    }

}