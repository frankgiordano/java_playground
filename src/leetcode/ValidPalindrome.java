package leetcode;

/*
https://leetcode.com/problems/valid-palindrome/
125. Valid Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters
and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

author francesco giordano
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {

        if (s == null || s.length() == 0)
            return true;

        int i = 0;
        int j = s.length()-1;

        while (i <= j) {

            char c1 = Character.toLowerCase(s.charAt(i));
            char c2 = Character.toLowerCase(s.charAt(j));

            if (! ((c1 > 96 && c1 < 123) || (c1 > 47 && c1 < 58))) {
                i++;
                continue;
            }

            if (! ((c2 > 96 && c2 < 123) || (c2 > 47 && c2 < 58))) {
                j--;
                continue;
            }

            if (c1 != c2)
                return false;

            i++;
            j--;

        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(ValidPalindrome.isPalindrome("0P"));
        System.out.println(ValidPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
    }

}
