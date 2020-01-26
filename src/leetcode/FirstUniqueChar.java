package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/

Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

Examples:

s = "leetcode"
return 0.

s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.

author francesco giordano
 */
public class FirstUniqueChar {

    public static int get(String s) {

        // time O(n) + O(n) = n + n = 2n = O(n)
        // space O(n)
        Map<Character, Integer> letters = new HashMap<Character, Integer>();

        // time O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (letters.containsKey(c)) {
                int count = letters.get(c);
                letters.put(c, ++count);
            } else {
                letters.put(c, 1);
            }
        }

        // time O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = letters.get(c);
            if (count == 1)
                return i;
        }

        return -1;
    }

    public static int get2(String s) {
        // this solution is faster than using hashmap
        // time O(n) + O(n) + O(n) = n + n + n = 3n = O(n)
        // space O(n)
        int[] chars = new int[26];

        for (int i = 0; i < 26; i++)
            chars[i] = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int currCount = chars[index];
            chars[index] = ++currCount;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1)
                return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        String input = "loveleetcode";
        System.out.println(FirstUniqueChar.get(input));
        System.out.println(FirstUniqueChar.get2(input));
    }

}
