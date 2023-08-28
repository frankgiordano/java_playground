package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.LinkedList;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.Node;
import educative.io.courses.dataStructuresInJavaAnInterviewRefresher.linkedlist.SingleLinkedListOperations;

import java.util.HashSet;
import java.util.Set;

/*
Challenge 8 : Remove Duplicates from a Linked List

Given a linked list, remove duplicates from it and implement 
the solution in Java. Solve this exercise and see if your output 
matches the expected output.

author: francesco giordano
*/
public class RemoveDuplicatesChallenge {

    public static String removeDuplicatesWithHashing(LinkedList list) {
        // time O(n) 
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

    // Helper Function to convert List elements in a single string
    private static String elements(LinkedList list) {

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

        SingleLinkedListOperations.insertAtEnd(list, 1);
        SingleLinkedListOperations.insertAtEnd(list, 2);
        SingleLinkedListOperations.insertAtEnd(list, 4);
        SingleLinkedListOperations.insertAtEnd(list, 2);
        SingleLinkedListOperations.insertAtEnd(list, 3);
        SingleLinkedListOperations.insertAtEnd(list, 5);
        SingleLinkedListOperations.insertAtEnd(list, 5);

        System.out.println(RemoveDuplicatesChallenge.removeDuplicatesWithHashing(list));
    }

}

