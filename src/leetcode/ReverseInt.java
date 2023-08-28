package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
https://leetcode.com/problems/reverse-integer/
7. Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Note:
Assume we are dealing with an environment that could only store integers
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose 
of this problem, assume that your function returns 0 when the reversed 
integer overflows.

author francesco giordano
 */
public class ReverseInt {
    public static int reverse(int x) {

        if (x < 10 && x > -10)
            return x; // means one digit sent nothing to reverse

        List<Integer> nums = new ArrayList<>();
        int nextInt = 0;

        while (x != 0) {
            nextInt = x % 10;
            x = x / 10;
            nums.add(nextInt);
        }

        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            try {
                sum = sum * 10 + nums.get(i);
            } catch (NumberFormatException e) {
                return 0;
            }
        }

        if (sum > Integer.MAX_VALUE)
            return 0;

        return (int) sum;
    }

    public static int reverse1(int x) {

        // means one digit sent nothing to reverse
        if (x < 10 && x > -10)
            return x;

        long sum = 0;
        while (x != 0) {
            sum = sum * 10 + x % 10;
            x = x / 10;
        }

        if (sum > Integer.MAX_VALUE || sum < Integer.MIN_VALUE)
            return 0;

        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(ReverseInt.reverse(1534236469));
    }
}