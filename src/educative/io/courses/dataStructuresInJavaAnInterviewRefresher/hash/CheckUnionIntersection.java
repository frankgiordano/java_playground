package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashSet;
import java.util.Set;

/*
Challenge 9: Union and Intersection of Lists using Hashing
Given two lists, find the Union & Intersection of their elements
using Hashing. Solve this exercise and see if your output matches
the expected output.

author: francesco giordano
*/
public class CheckUnionIntersection {

    public static <T> SinglyLinkedList<T> unionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        Set<T> visited = new HashSet<T>();

        SinglyLinkedList<T>.Node node = list1.getHeadNode();
        while (node != null) {
            if (!visited.contains(node.data)) {
                visited.add(node.data);
                result.insertAtHead(node.data);
            }
            node = node.nextNode;
        }
        node = list2.getHeadNode();
        while (node != null) {
            if (!visited.contains(node.data)) {
                visited.add(node.data);
                result.insertAtHead(node.data);
            }
            node = node.nextNode;
        }
        return result;
    }

    //performs intersection between list
    public static <T> SinglyLinkedList<T> intersectionWithHashing(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        SinglyLinkedList<T> result = new SinglyLinkedList<T>();
        Set<T> visited = new HashSet<T>();

        SinglyLinkedList<T>.Node node = list1.getHeadNode();
        while (node != null) {
            if (visited.contains(node.data)) {
                result.insertAtHead(node.data);
            } else {
                visited.add(node.data);
            }
            node = node.nextNode;
        }
        node = list2.getHeadNode();
        while (node != null) {
            if (visited.contains(node.data)) {
                result.insertAtHead(node.data);
            } else {
                visited.add(node.data);
            }
            node = node.nextNode;
        }
        return result;
    }

    public static void main(String[] args) {

        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
        list1.insertAtHead(8);
        list1.insertAtHead(22);
        list1.insertAtHead(15);

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
        list2.insertAtHead(7);
        list2.insertAtHead(14);
        list2.insertAtHead(22);

        SinglyLinkedList<Integer> result = new SinglyLinkedList<Integer>();
        result = CheckUnionIntersection.unionWithHashing(list1, list2);

        SinglyLinkedList<Integer>.Node node = result.getHeadNode();
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.nextNode;
        }
        System.out.println("->null");

        result = CheckUnionIntersection.intersectionWithHashing(list1, list2);

        node = result.getHeadNode();
        while (node != null) {
            System.out.print(node.data + "->");
            node = node.nextNode;
        }
        System.out.println("->null");

    }

}