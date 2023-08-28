package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashSet;
import java.util.Set;

/*
Challenge 8 : Remove Duplicates from a Linked List

Given a linked list, remove duplicates from it and implement 
the solution in Java. Solve this exercise and see if your output 
matches the expected output.

This example uses the SinglyLinkedList from educative.io

author: francesco giordano
*/
public class RemoveDuplicatesChallenge2 {

    public static String removeDuplicatesWithHashing(SinglyLinkedList<Integer> list) {
        // time O(n) 
        Set<Integer> visitedNodes = new HashSet<Integer>();
        SinglyLinkedList<Integer>.Node finger = list.getHeadNode();
        SinglyLinkedList<Integer>.Node prev = null;

        while (finger != null) {
            Object checkValue = finger.data;
            if (visitedNodes.contains((int) checkValue)) {
                prev.nextNode = finger.nextNode;
                finger = finger.nextNode;
                System.out.println("found duplicate");
                continue;
            }
            visitedNodes.add((int) checkValue);
            prev = finger;
            finger = finger.nextNode;
        }

        return elements(list);
    }

    // Helper Function to convert List elements in a single string
    private static <V> String elements(SinglyLinkedList<V> list) {

        String elementsList = "";

        SinglyLinkedList<V>.Node start = list.getHeadNode();

        while (start != null) {
            elementsList += start.data;
            elementsList += "->";
            start = start.nextNode;
        }

        elementsList += "null";
        return elementsList;
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(4);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtEnd(5);
        list.insertAtEnd(5);

        System.out.println(RemoveDuplicatesChallenge2.removeDuplicatesWithHashing(list));
    }

}

