package leetcode;

/*
Roman to Integer

See https://leetcode.com/problems/roman-to-integer/

author: francesco giordano
 */
public class romanToInteger {

    public static int romanToInt(String s) {

        // O(n) time
        // O(1) space

        int size = s.length();
        int num = 0;
        char prevoiusChar = '1';

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);

            switch (c) {
                case 'I':
                    num = num + 1;
                    break;
                case 'V':
                    num = num + 5;
                    if (prevoiusChar == 'I')
                        num = num - 2;
                    break;
                case 'X':
                    num = num + 10;
                    if (prevoiusChar == 'I')
                        num = num - 2;
                    break;
                case 'L':
                    num = num + 50;
                    if (prevoiusChar == 'X')
                        num = num - 20;
                    break;
                case 'C':
                    num = num + 100;
                    if (prevoiusChar == 'X')
                        num = num - 20;
                    break;
                case 'D':
                    num = num + 500;
                    if (prevoiusChar == 'C')
                        num = num - 200;
                    break;
                case 'M':
                    num = num + 1000;
                    if (prevoiusChar == 'C')
                        num = num - 200;
                    break;
            }
            prevoiusChar = c;
        }

        return num;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger.romanToInt("XXVII"));
    }
}
