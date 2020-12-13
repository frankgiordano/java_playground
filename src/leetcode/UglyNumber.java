package leetcode;

/*
https://leetcode.com/problems/ugly-number/
263. Ugly Number

Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
*/
public class UglyNumber {

    public static boolean isUgly(int num) {
        if (num == 0)
            return false;
        if (num == 1)
            return true;

        if (num % 2 == 0) {
            num = num / 2;
            return isUgly(num);
        }

        if (num % 3 == 0) {
            num = num / 3;
            return isUgly(num);
        }

        if (num % 5 == 0) {
            num = num / 5;
            return isUgly(num);
        }

        return false;
    }
    
    public static void main (String[] args) {
        System.out.println(" is ugly = " + UglyNumber.isUgly(6));
    }

}