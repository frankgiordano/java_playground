package leetcode;

/*
https://leetcode.com/problems/reverse-string/
344. Reverse String

Write a function that reverses a string. The input string is given as an array of
characters char[].

Do not allocate extra space for another array, you must do this by modifying the
input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

author francesco giordano
 */
public class ReverseCharArray {

    public static void reverseString(char[] s) {
        // time O(n)
        // space O(1)

        if (s == null)
            return;

        int index1 = 0;
        int index2 = s.length - 1;

        while (index1 < index2) {
            char c = s[index1];
            s[index1++] = s[index2];
            s[index2--] = c;
        }
    }

    public static void reverseString2(char[] s) {
        // time O(n)
        // space O(n)
        reverse(0, s.length - 1, s);
    }

    public static void reverse(int index1, int index2, char[] s) {
        if (index1 > index2)
            return;
        char c = s[index1];
        s[index1++] = s[index2];
        s[index2--] = c;
        reverse(index1, index2, s);
    }

    public static void main(String args[]) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        ReverseCharArray.reverseString(s);
        System.out.println(s);
        ReverseCharArray.reverseString2(s);
        System.out.println(s);
    }

}
