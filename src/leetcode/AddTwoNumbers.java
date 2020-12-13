package leetcode;

/*
https://leetcode.com/problems/add-two-numbers/
2. Add Two Numbers

You are given two non-empty linked lists representing two non-negative integers. The digits are stored
in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as
a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

author francesco giordano

Time complexity : O(max(m, n)). Assume that mm and nn represents the length of l1l1 and l2l2 respectively,
the algorithm above iterates at most \max(m, n)max(m,n) times.

Space complexity : O(max(m, n)). The length of the new list is at most max(m,n)+1.
*/
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resultList = new ListNode(0);
        ListNode pointer = resultList;

        // we could use l1 and l2 themselves to loop through the list but then
        // we lose the pointer to the head of the lists as we are pass by reference
        // so defined two other pointers...
        ListNode p1 = l1;
        ListNode p2 = l2;

        int carry = 0;
        while (p1 != null || p2 != null) {
            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;
            int value = val1 + val2 + carry;

            // get the carry value it could either continue to be zero
            // or a valid non-zero carry
            // 13/10 = 1.3 = 1 is carried
            carry = value / 10;

            // always mod by 10 just in case the value is greater than
            // 10 which means a carry will be set and here we only need
            // non carried value for instance for 13 it is 3 which is
            // computed as 13%10 = 3, for a number less than 10, the computed
            // value for instance for 9 will be 9%10 = 9
            value = value % 10;
            pointer.next = new ListNode(value);
            pointer = pointer.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        if (carry > 0) {
            pointer.next = new ListNode(carry);
        }

        return resultList.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;

        ListNode result = AddTwoNumbers.addTwoNumbers(node1, node4);
        ListNode curr = result;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }

}
