package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist;

class NodeD {
    public int data;
    public NodeD nextElement;
    NodeD previousElement;
}

class DoubleLinkedList {

    public NodeD headNode;

    // Constructor - Initializing Head NodeD
    DoubleLinkedList() {
        headNode = new NodeD();
    }

    // Helper Function that checks if List is empty or not 
	public boolean isEmpty() {

		if (headNode.nextElement == null) return true;
		return false;
	}

    // Helper Function to printList  
    public boolean printList() {

        if (isEmpty()) {
            System.out.println("List is Empty");
            return false;
        }

        NodeD temp = headNode.nextElement;
        System.out.print("List : ");

        while (temp.nextElement != null) {
            System.out.print(temp.data + "->");
            temp = temp.nextElement;
        }

        System.out.println(temp.data + "->null");
        return true;
    }

}

class DoubleLinkedListOperations {

    public static int length(DoubleLinkedList list){
        NodeD finger = list.headNode;
        int count = 0;
        
        if (finger.nextElement == null)
          return count;
    
        while (finger.nextElement != null) {
            finger = finger.nextElement;
            count++;
        }
    
        return count;  
    }

    public static String reverse(DoubleLinkedList list) {

        NodeD curr = list.headNode.nextElement;
        NodeD next = curr.nextElement;
        NodeD prev = null; 

        while (next != null) {
            curr.nextElement = prev;
            curr.previousElement = next;
            prev = curr;
            curr = next;
            next = next.nextElement;
        }

        curr.nextElement = prev;
        list.headNode.nextElement = curr;

        return elements(list);
    }

    public static boolean searchNode(DoubleLinkedList list, int value) {
        NodeD finger = list.headNode;

        while(finger != null) {

            if (finger.data == value) {
                return true;                
            }
            finger = finger.nextElement;
        }

        return false;
    }

    // Inserts a value at the start of list
    public static String insertAtStart(DoubleLinkedList list, int value) {
        NodeD newNode = new NodeD();
        newNode.data = value;
        newNode.nextElement = list.headNode.nextElement;
        newNode.previousElement = list.headNode;
        list.headNode.nextElement = newNode; 
        return elements(list);
    }

    // Helper Function to convert List elements in a single string
	public static String elements(DoubleLinkedList list) {

		String elementsList = "";

		NodeD start = list.headNode.nextElement;

		while (start != null) {
			elementsList += start.data;
			elementsList += "->";
			start = start.nextElement;
		}

		elementsList += "null";

		return elementsList;
    }
    
    public static void main(String[] args) {

        DoubleLinkedList list = new DoubleLinkedList();
        System.out.println("Testing inserting values at start of list");
        DoubleLinkedListOperations.insertAtStart(list, 1);
        list.printList();
        DoubleLinkedListOperations.insertAtStart(list, 2);
        list.printList();
        DoubleLinkedListOperations.insertAtStart(list, 3);
        list.printList();
        System.out.println("Found 3 in list = " + DoubleLinkedListOperations.searchNode(list, 3));
        System.out.println("reverse list = " + DoubleLinkedListOperations.reverse(list));
    }

}