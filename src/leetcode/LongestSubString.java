package leetcode;

import java.util.HashSet;
import java.util.Set;
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Given a string, find the length of the longest substring without repeating characters.

author francesco giordano
 */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {

        // this is brute force approach but using a Set
        // time O(n^)

        if (s == null || s.length() == 0)
            return 0;

        Set<Character> characters = new HashSet<Character>();
        int maxLength = 0;
        int currLength = 0;

        if (s.length() == 1)
            return 1;

        for (int i = 0; i < s.length(); i++) {
            if (currLength > maxLength)
                maxLength = currLength;
            characters.clear();
            characters.add(s.charAt(i));
            currLength = 1;
            for (int j = i+1; j < s.length(); j++) {
                if (characters.contains(s.charAt(j))) {
                    if (currLength > maxLength) {
                        maxLength = currLength;
                    }
                    break;
                }
                currLength++;
                characters.add(s.charAt(j));
            }
        }

        return maxLength;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> characters = new HashSet<Character>();

        int count = 0;
        while (j < s.length()) {

            if (characters.contains(s.charAt(j))) {
                if (count > max)
                    max = count;
                characters.clear();
                i++;
                j = i;
                count = 0;
            }

            characters.add(s.charAt(j));
            count++;
            j++;
        }

        if (count > max)
            max = count;

        return max;
    }

    public static int lengthOfLongestSubstring3(String s) {

        // sliding window technique..
        // time O(n)

        if (s == null || s.length() == 0)
            return 0;

        int i = 0;
        int j = 0;
        int max = 0;

        Set<Character> characters = new HashSet<Character>();

        while (j < s.length()) {
            if (!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j));
                max = Math.max(characters.size(), max);
                j++;
            } else {
                characters.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(LongestSubString.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(LongestSubString.lengthOfLongestSubstring2("abcabcbb"));
        System.out.println(LongestSubString.lengthOfLongestSubstring2("bbbb"));
        System.out.println(LongestSubString.lengthOfLongestSubstring2("dvdf"));
        System.out.println(LongestSubString.lengthOfLongestSubstring3("dvdf"));
    }
}
