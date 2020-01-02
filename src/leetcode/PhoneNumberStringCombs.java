package leetcode;

import java.util.*;

/*
https://leetcode.com/problems/letter-combinations-of-a-phone-number/

Given a string containing digits from 2-9 inclusive, return all possible letter
combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
Note that 1 does not map to any letters.

author francesco giordano

This is a classic BFS solution.
 */
public class PhoneNumberStringCombs {

    public static List<String> letterCombinations(String digits) {

        Queue<String> list = new LinkedList<String>();

        if (digits == null || digits.isEmpty())
            return (List) list;

        Map<Character, String> numbers = new HashMap<Character, String>();
        numbers.put('0', "0");
        numbers.put('1', "1");
        numbers.put('2', "abc");
        numbers.put('3', "def");
        numbers.put('4', "ghi");
        numbers.put('8', "tuv");
        numbers.put('9', "wxyz");
        numbers.put('5', "jkl");
        numbers.put('6', "mno");
        numbers.put('7', "pqrs");

        // this adds a zero length string item to the queue
        // this is needed for the while loop
        // each iteration of the digits will add to increased length
        list.add("");

        for (int i = 0; i < digits.length(); i++) {

            char number = digits.charAt(i);
            String letters = numbers.get(number);

            while (list.peek().length() == i) {
                String combo = list.remove();

                // add each letter of letters to the queue
                for (int j = 0; j < letters.length(); j++) {
                    list.add(combo + Character.toString(letters.charAt(j)));
                }
            }
        }

        return (List) list;
    }

    public static void main(String[] args) {
        String digits = "9345";
        System.out.println(PhoneNumberStringCombs.letterCombinations(digits));
    }
}


