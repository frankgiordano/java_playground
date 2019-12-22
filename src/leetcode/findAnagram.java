package leetcode;

import java.util.Arrays;

public class findAnagram {

    public static final int ASCII_NUMS = 256; //  8-bit

    public static boolean isAnagram1(String str1, String str2) {

        // O(n) - time
        // O(n) - space

        if (str1.length() != str2.length()) 
            return false;

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();

        int[] count1 = new int[ASCII_NUMS];
        int[] count2 = new int[ASCII_NUMS];

        Arrays.fill(count1, 0);
        Arrays.fill(count2, 0);

        for (int i = 0 ; i < charArray1.length; i++) {
            count1[charArray1[i]] += 1;
            count2[charArray2[i]] += 1;
        }

        for (int i = 0 ; i < ASCII_NUMS; i++) {
            if (count1[i] != count2[i]) 
                return false;
        }

        return true;
    }

    public static boolean isAnagram2(String str1, String str2) {

        // O(nlogn) - time

        if (str1.length() != str2.length()) 
            return false;

        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        str1 = String.valueOf(charArray1);
        str2 = String.valueOf(charArray2);
        if (!str1.equals(str2)) 
            return false;

        return true;
    }

    public static boolean isAnagram3(String str1, String str2) {

        // O(n * m) - time - brute force

        if (str1.length() != str2.length()) 
            return false;

        boolean found = true;
        for (int i = 0; i < str1.length(); i++) {
            if (!found)
                return false;
            for (int j = 0; j < str1.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    found = true;
                }
                else found = false;
            }
        }

        return found;
    }

    public static void main(String[] args) {

        System.out.println(findAnagram.isAnagram1("frank", "frakn"));
        System.out.println(findAnagram.isAnagram1("frankk", "frakn"));
        System.out.println(findAnagram.isAnagram1("K", "k"));

        System.out.println(findAnagram.isAnagram2("frank", "frakn"));
        System.out.println(findAnagram.isAnagram2("frankk", "frakn"));
        System.out.println(findAnagram.isAnagram2("K", "k"));

        System.out.println(findAnagram.isAnagram3("frank", "frakn"));
        System.out.println(findAnagram.isAnagram3("frankk", "frakn"));
        System.out.println(findAnagram.isAnagram3("K", "k"));
    }

}