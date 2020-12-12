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

    /**
     * Runtime: 1 ms, faster than 78.72% of Java online submissions for Letter
     * Combinations of a Phone Number. Memory Usage: 37.8 MB, less than 73.82% of
     * Java online submissions for Letter Combinations of a Phone Number.
     * 
     * This version uses a second LinkedList and as such uses more space. It also
     * uses a String array as HashMap value.
     */
    public static List<String> letterCombinations1(String digits) {
        LinkedList<String> lst = new LinkedList<String>();

        if (digits == null || digits.isEmpty())
            return lst;

        if (digits.length() == 1 && "1".equals(digits))
            return lst;

        HashMap<String, String[]> dialPad = new HashMap<String, String[]>();

        String[] letters2 = { "a", "b", "c" };
        dialPad.put("2", letters2);
        String[] letters3 = { "d", "e", "f" };
        dialPad.put("3", letters3);
        String[] letters4 = { "g", "h", "i" };
        dialPad.put("4", letters4);
        String[] letters5 = { "j", "k", "l" };
        dialPad.put("5", letters5);
        String[] letters6 = { "m", "n", "o" };
        dialPad.put("6", letters6);
        String[] letters7 = { "p", "q", "r", "s" };
        dialPad.put("7", letters7);
        String[] letters8 = { "t", "u", "v" };
        dialPad.put("8", letters8);
        String[] letters9 = { "w", "x", "y", "z" };
        dialPad.put("9", letters9);

        lst.add("");

        for (int i = 0; i < digits.length(); i++) {
            // for example get key "2" digit and return its values a b c
            String key = String.valueOf(digits.charAt(i));
            String[] values = dialPad.get(key);

            LinkedList<String> tmp = new LinkedList<String>();
            while (lst.peek() != null) {
                String item = lst.pop();
                for (int j = 0; j < values.length; j++) {
                    tmp.add(item + values[j]);
                }
            }
            lst.addAll(tmp);

        }

        return lst;
    }

    /**
     * Runtime: 1 ms, faster than 78.72% of Java online submissions for Letter
     * Combinations of a Phone Number. Memory Usage: 38.1 MB, less than 64.69% of
     * Java online submissions for Letter Combinations of a Phone Number.
     */
    public static List<String> letterCombinations2(String digits) {

        Queue<String> list = new LinkedList<String>();

        if (digits == null || digits.isEmpty())
            return new ArrayList<>(list);

        Map<Character, String> numbers = new HashMap<Character, String>();
        numbers.put('0', "0");
        numbers.put('1', "1");
        numbers.put('2', "abc");
        numbers.put('3', "def");
        numbers.put('4', "ghi");
        numbers.put('5', "jkl");
        numbers.put('6', "mno");
        numbers.put('7', "pqrs");
        numbers.put('8', "tuv");
        numbers.put('9', "wxyz");

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

        return new ArrayList<>(list);
    }

    /**
     * Runtime: 1 ms, faster than 78.72% of Java online submissions for Letter
     * Combinations of a Phone Number. Memory Usage: 37.7 MB, less than 79.77% of
     * Java online submissions for Letter Combinations of a Phone Number.
     * 
     * This version uses a more striaght forward way to hold the phone key pad info
     * instead of using a HashMap. I removed the usage of Queue data structure and
     * avoided the casting done in letterCombinations2.
     * 
     * This version looks better than version 1 and 2.
     */
    public static List<String> letterCombinations3(String digits) {

        LinkedList<String> list = new LinkedList<String>();

        if (digits == null || digits.isEmpty())
            return list;

        String[] numbers = new String[10];
        numbers[0] = "0";
        numbers[1] = "1";
        numbers[2] = "abc";
        numbers[3] = "def";
        numbers[4] = "ghi";
        numbers[5] = "jkl";
        numbers[6] = "mno";
        numbers[7] = "pqrs";
        numbers[8] = "tuv";
        numbers[9] = "wxyz";

        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = numbers[Character.getNumericValue(digits.charAt(i))];

            while (list.peek().length() == i) {
                String combo = list.remove();

                // add each letter of letters to the queue
                for (int j = 0; j < letters.length(); j++) {
                    list.add(combo + Character.toString(letters.charAt(j)));
                }
            }
        }

        return list;
    }

    /**
     * Runtime: 4 ms, faster than 44.70% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 39.6 MB, less than 5.22% of Java online submissions for Letter Combinations of a Phone Number.
     * 
     * Leetcode reports this method to be the worst of all others. This is due to the fact of:
     * lst.add(item + values.charAt(j));
     * instead of 
     * lst.add(item + Character.toString(values.charAt(j)));
     * 
     * high memory and cpu usage due to string + of a char
     */
    public static List<String> letterCombinations4(String digits) {
        LinkedList<String> lst = new LinkedList<String>();

        if (digits == null || digits.isEmpty())
            return lst;

        String[] dialPad = new String[10];
        dialPad[0] = "0";
        dialPad[1] = "1";
        dialPad[2] = "abc";
        dialPad[3] = "def";
        dialPad[4] = "ghi";
        dialPad[5] = "jkl";
        dialPad[6] = "mno";
        dialPad[7] = "pqrs";
        dialPad[8] = "tuv";
        dialPad[9] = "wxyz";

        lst.add("");
        for (int i = 0; i < digits.length(); i++) {
            String values = dialPad[Character.getNumericValue(digits.charAt(i))];

            while (lst.peek().length() == i) {
                String item = lst.pop();
                for (int j = 0; j < values.length(); j++) {
                    lst.add(item + values.charAt(j));
                }
            }

        }

        return lst;
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Letter Combinations of a Phone Number.
     * Memory Usage: 37.7 MB, less than 79.77% of Java online submissions for Letter Combinations of a Phone Number.
     * 
     * This version using StringBuilder and provides the best leetcode results!
     */
    public static List<String> letterCombinations5(String digits) {
        LinkedList<String> lst = new LinkedList<String>();
        
        if (digits == null || digits.isEmpty())
            return lst;
        
        String[] dialPad = new String[10];
        dialPad[0] = "0";
        dialPad[1] = "1";
        dialPad[2] = "abc";
        dialPad[3] = "def";
        dialPad[4] = "ghi";
        dialPad[5] = "jkl";
        dialPad[6] = "mno";
        dialPad[7] = "pqrs";
        dialPad[8] = "tuv";
        dialPad[9] = "wxyz";
        
        lst.add("");
        for (int i = 0; i < digits.length(); i++) {
            String values = dialPad[Character.getNumericValue(digits.charAt(i))];
        
            while (lst.peek().length() == i) {
                String item = lst.pop();
                
                for (int j = 0; j < values.length(); j++) {
                    StringBuilder str = new StringBuilder();
                    str.append(item);
                    str.append(values.charAt(j));
                    lst.add(str.toString());
                }
            }
        
        }
        
        return lst;
    }
    
    public static void main(String[] args) {
        String digits = "9345";
        System.out.println(PhoneNumberStringCombs.letterCombinations1(digits));
        digits = "9345";
        System.out.println(PhoneNumberStringCombs.letterCombinations2(digits));
        digits = "9345";
        System.out.println(PhoneNumberStringCombs.letterCombinations3(digits));
        digits = "9345";
        System.out.println(PhoneNumberStringCombs.letterCombinations4(digits));
        digits = "9345";
        System.out.println(PhoneNumberStringCombs.letterCombinations5(digits));
    }
    
}
