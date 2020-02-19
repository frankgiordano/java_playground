package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Sort Characters By Frequency

Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.

author francesco giordano
 */
public class FrequencySort {

    public static String sort(String s) {

        Map<Character, Integer> charFreq = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charFreq.containsKey(c)) {
                charFreq.put(c, 1);
            } else {
                int count = charFreq.get(c);
                charFreq.put(c, ++count);
            }
        }

        PriorityQueue<Character> pQueue = new PriorityQueue<Character>((a, b) -> charFreq.get(b) - charFreq.get(a));
        pQueue.addAll(charFreq.keySet());

        StringBuilder result = new StringBuilder("");
        while (!pQueue.isEmpty()) {
            Character c = pQueue.poll();
            int count = charFreq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static String sort2(String s) {

        Map<Character, Integer> charFreq = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            int count = charFreq.getOrDefault(s.charAt(i), 0);
            charFreq.put(s.charAt(i), ++count);
        }

        PriorityQueue<Character> pQueue = new PriorityQueue<Character>((a, b) -> charFreq.get(b) - charFreq.get(a));
        pQueue.addAll(charFreq.keySet());

        StringBuilder result = new StringBuilder("");
        while (!pQueue.isEmpty()) {
            Character c = pQueue.poll();
            int count = charFreq.get(c);
            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(FrequencySort.sort("tree"));
        System.out.println(FrequencySort.sort2("tree"));
    }

}
