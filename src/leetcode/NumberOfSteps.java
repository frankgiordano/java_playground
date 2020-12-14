package leetcode;

/*
Number of Steps to Reduce a Number to Zero

Given a non-negative integer num, return the number of steps to reduce it to zero. If the current number is even,
you have to divide it by 2, otherwise, you have to subtract 1 from it.

Example 1:

Input: num = 14
Output: 6
Explanation:
Step 1) 14 is even; divide by 2 and obtain 7.
Step 2) 7 is odd; subtract 1 and obtain 6.
Step 3) 6 is even; divide by 2 and obtain 3.
Step 4) 3 is odd; subtract 1 and obtain 2.
Step 5) 2 is even; divide by 2 and obtain 1.
Step 6) 1 is odd; subtract 1 and obtain 0.

author francesco giordano
 */
public class NumberOfSteps {

    public static int nos(int num) {
        int count = 0;
        while (num > 0) {
            int result = num % 2;
            if (result == 0)
                num = num / 2;
            if (result != 0)
                num = num - 1;
            count++;
        }
        return count;
    }

    public static int nos2(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            if (num % 2 == 0) {
                num = num / 2;
                continue;
            }
            if (num % 2 != 0) {
                num = num - 1;
                continue;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(NumberOfSteps.nos(14));
        System.out.println(NumberOfSteps.nos2(14));
    }

}
