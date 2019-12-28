package leetcode;

import java.util.HashSet;
import java.util.Set;

// value 3 = 3*3 = 9 = 9*9 = 81 = 8*8 + 1*1 = 65 = 6*6 + 5*5 = 36+25 = 61 = 6*6 + 1*1 = 37 = 3*3 + 7*7 = 58 = 25 + 64 = 89 
// 8*8 + 9*9 = 64 +81 = 145 = 1 + 16 + 25 = 42 = 16 + 4 = 20 = 4 = 16 = 1+36 = 37 = repeated not luckly

public class HappyNumber {

    public static boolean isHappy(int n) {

        Set<Integer> seenNums = new HashSet<Integer>();

        while (!seenNums.contains(n)) {
            seenNums.add(n);

            n = getSquaredSum(n);
            System.out.println(n);
            if (n == 1)
                return true;
        }

        return false;
    }

    public static int getSquaredSum(int n) {
        if (n == 1) return 1;
        if (n == 0) return 0;

        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n = n / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(HappyNumber.isHappy(3));
    }
}