package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/first-unique-character-in-a-string/
387. First Unique Character in a String

Given a string, find the first non-repeating character in it and return it's index. 
If it doesn't exist, return -1.

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
        Map<Character, Integer> letters = new HashMap<>();

        // time O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // let's use the java 8 way!!
            letters.compute(c, (k, v) -> (v == null) ? 1 : ++v);
            // if (letters.containsKey(c)) {
            //     int count = letters.get(c);
            //     letters.put(c, ++count);
            // } else {
            //     letters.put(c, 1);
            // }
        }

        // time O(n)
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = letters.get(c);
            if (count == 1) {
                return i;
            }
        }

        return -1;
    }

    public static int get2(String s) {
        // this solution is faster than using hashmap
        // time O(n) + O(n) + O(n) = n + n = 2n = O(n + 26)
        // space O(n + 26)
        int[] chars = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            int currCount = chars[index];
            chars[index] = ++currCount;
        }

        for (int i = 0; i < s.length(); i++) {
            if (chars[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String input = "loveleetcode";
        System.out.println(FirstUniqueChar.get(input));
        System.out.println(FirstUniqueChar.get2(input));
    }

}
