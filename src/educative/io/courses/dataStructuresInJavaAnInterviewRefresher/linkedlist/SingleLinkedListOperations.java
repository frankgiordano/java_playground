package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist;

import java.util.Set;
import java.util.*;

public class SingleLinkedListOperations {

    public static int length(LinkedList list) {
        Node finger = list.headNode;
        int count = 0;

        if (finger.nextElement == null)
            return count;

        while (finger.nextElement != null) {
            finger = finger.nextElement;
            count++;
        }

        return count;
    }

    public static String deleteAtHead(LinkedList list) {
        if (list.headNode.nextElement != null)
            list.headNode = list.headNode.nextElement;

        return elements(list);
    }

    public static boolean delete(LinkedList list, int value) {
        boolean delete = false;
        Node finger = list.headNode;

        if (finger == null)
            return delete;

        Node previousNode = null;

        while (finger != null && finger.data != value) {
            previousNode = finger;
            finger = finger.nextElement;
        }

        if (finger == null)
            return delete;

        // at this point it was found
        delete = true;
        previousNode.nextElement = finger.nextElement;
        finger = null;

        return delete;
    }

    public static boolean delete2(LinkedList list, int value) {
        boolean delete = false;
        Node finger = list.headNode;

        if (finger == null)
            return delete;

        Node previousNode = null;

        while (finger != null) {

            if (finger.data == value) {
                delete = true;
                previousNode.nextElement = finger.nextElement;
                finger = null;
                break;
            }

            previousNode = finger;
            finger = finger.nextElement;
        }

        return delete;
    }

    public static boolean searchNode(LinkedList list, int value) {
        Node finger = list.headNode;

        if (finger == null)
            return false;

        if (finger.data == value)
            return true;

        while (finger != null && finger.data != value)
            finger = finger.nextElement;

        if (finger == null)
            return false;

        return true;
    }

    public static boolean detectLoop(LinkedList list) {

        Set<Node> visitedNodes = new HashSet<Node>();
        Node finger = list.headNode.nextElement;

        while (finger != null) {
            if (visitedNodes.contains(finger)) {
                return true;
            }
            visitedNodes.add(finger);
            finger = finger.nextElement;
        }

        return false;
    }

    public static int findMid(LinkedList list) {

        Node finger = list.headNode.nextElement;
        Node mid = finger;

        while (finger != null) {
            finger = finger.nextElement;
            if (finger != null)
                finger = finger.nextElement;
            if (finger == null)
                break;
            mid = mid.nextElement;
        }

        if (mid != null)
            return mid.data;

        return 0;
    }

    public static String removeDuplicates(LinkedList list) {

        Set<Integer> visitedNodes = new HashSet<Integer>();
        Node finger = list.headNode.nextElement;
        Node prev = null;

        while (finger != null) {
            Integer checkValue = Integer.valueOf(finger.data);
            if (visitedNodes.contains(checkValue)) {
                prev.nextElement = finger.nextElement;
                finger = finger.nextElement;
                System.out.println("found duplicate");
                continue;
            }
            visitedNodes.add(Integer.valueOf(finger.data));
            prev = finger;
            finger = finger.nextElement;
        }

        return elements(list);
    }

    public static String reverse(LinkedList list) {

        Node curr = list.headNode.nextElement;
        Node next = curr.nextElement;
        Node prev = null;

        while (next != null) {
            curr.nextElement = prev;
            prev = curr;
            curr = next;
            next = curr.nextElement;
        }

        curr.nextElement = prev;
        list.headNode.nextElement = curr;
        return elements(list);
    }

    public static String union(LinkedList list1, LinkedList list2) {

        Set<Integer> visitedNodes = new HashSet<Integer>();
        Node finger1 = list1.headNode.nextElement;
        Node finger2 = list2.headNode.nextElement;

        while (finger1 != null) {
            visitedNodes.add(Integer.valueOf(finger1.data));
            finger1 = finger1.nextElement;
        }

        while (finger2 != null) {
            if (visitedNodes.contains(Integer.valueOf(finger2.data))) {
                continue;
            }

            Node newNode = new Node();
            newNode.data = finger2.data;
            finger1 = list1.headNode;

            while (finger1.nextElement != null)
                finger1 = finger1.nextElement;

            finger1.nextElement = newNode;
            newNode.nextElement = null;

            finger2 = finger2.nextElement;
        }
        return elements(list1);
    }

    public static String intersection(LinkedList list1, LinkedList list2) {

        String result = "";
        Set<Integer> visitedNodes = new HashSet<Integer>();
        LinkedList newList = new LinkedList();
        Node finger1 = list1.headNode.nextElement;
        Node finger2 = list2.headNode.nextElement;

        while (finger1 != null) {
            visitedNodes.add(Integer.valueOf(finger1.data));
            finger1 = finger1.nextElement;
        }

        while (finger2 != null) {
            if (visitedNodes.contains(Integer.valueOf(finger2.data))) {
                Node newNode = new Node();
                newNode.data = finger2.data;
                Node finger3 = newList.headNode;

                while (finger3.nextElement != null)
                    finger3 = finger3.nextElement;

                finger3.nextElement = newNode;
                newNode.nextElement = null;
            }
            finger2 = finger2.nextElement;
        }

        result = elements(newList);
        return result;
    }

    public static String insertAfter(LinkedList list, int value, int previous) {
        Node newNode = new Node();
        newNode.data = value;
        Node finger = list.headNode;

        while (finger.data != previous)
            finger = finger.nextElement;

        newNode.nextElement = finger.nextElement;
        finger.nextElement = newNode;

        return elements(list);
    }

    // Inserts a value at the end of the list
    public static String insertAtEnd(LinkedList list, int value) {
        Node newNode = new Node();
        newNode.data = value;
        Node finger = list.headNode;

        while (finger.nextElement != null)
            finger = finger.nextElement;

        finger.nextElement = newNode;
        newNode.nextElement = null;

        return elements(list);
    }

    // Inserts a value at the start of list
    public static String insertAtStart(LinkedList list, int value) {
        Node newNode = new Node();
        newNode.data = value;
        newNode.nextElement = list.headNode.nextElement;
        list.headNode.nextElement = newNode;
        return elements(list);
    }

    // Helper Function to convert List elements in a single string
    public static String elements(LinkedList list) {

        String elementsList = "";

        Node start = list.headNode.nextElement;

        while (start != null) {
            elementsList += start.data;
            elementsList += "->";
            start = start.nextElement;
        }

        elementsList += "null";

        return elementsList;
    }

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        System.out.println("Testing inserting values at end of list");
        SingleLinkedListOperations.insertAtEnd(list, 1);
        list.printList();
        SingleLinkedListOperations.insertAtEnd(list, 2);
        list.printList();
        SingleLinkedListOperations.insertAtEnd(list, 3);
        list.printList();
        SingleLinkedListOperations.insertAtEnd(list, 5);
        list.printList();
        System.out.println("Testing inserting 4 after node 3");
        SingleLinkedListOperations.insertAfter(list, 4, 3);
        list.printList();

        LinkedList list2 = new LinkedList();
        System.out.println("Testing inserting values at start of list2");
        SingleLinkedListOperations.insertAtStart(list2, 1);
        list2.printList();
        SingleLinkedListOperations.insertAtStart(list2, 2);
        list2.printList();
        SingleLinkedListOperations.insertAtStart(list2, 3);
        list2.printList();

        System.out.println("Found 3 in list1 = " + SingleLinkedListOperations.searchNode(list, 3));
        System.out.println("Found 13 in list1 = " + SingleLinkedListOperations.searchNode(list, 13));
        System.out.println("delete 4 in list1 = " + SingleLinkedListOperations.delete(list, 4));
        list.printList();
        System.out.println("delete 4 in list1 = " + SingleLinkedListOperations.delete(list, 4));
        System.out.println("delete 2 in list1 = " + SingleLinkedListOperations.delete2(list, 2));
        list.printList();
        System.out.println("delete 2 in list1 = " + SingleLinkedListOperations.delete2(list, 2));
        System.out.println("delete head in list1 = " + SingleLinkedListOperations.deleteAtHead(list));
        list.printList();
        System.out.println("size of list1 = " + SingleLinkedListOperations.length(list));
        System.out.println("reverse list2 = " + SingleLinkedListOperations.reverse(list2));
        System.out.println("mid of list2 = " + SingleLinkedListOperations.findMid(list2));

        LinkedList list3 = new LinkedList();
        System.out.println("Testing inserting values at start of list3");
        SingleLinkedListOperations.insertAtStart(list3, 1);
        list2.printList();
        SingleLinkedListOperations.insertAtStart(list3, 2);
        list2.printList();
        SingleLinkedListOperations.insertAtStart(list3, 3);
        list2.printList();
        SingleLinkedListOperations.insertAtStart(list3, 3);
        list2.printList();
        SingleLinkedListOperations.insertAtStart(list3, 4);
        list2.printList();
        SingleLinkedListOperations.removeDuplicates(list3);
    }

}