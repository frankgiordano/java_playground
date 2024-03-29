package leetcode;

import java.util.Arrays;

/*
https://leetcode.com/problems/missing-number/
268. Missing Number

Given an array nums containing n distinct numbers in the range [0, n], return
the only number in the range that is missing from the array.

Follow up: Could you implement a solution using only O(1) extra space complexity 
and O(n) runtime complexity?
*/
public class MissingNumber {

    public static int getMissingNumber1(int[] nums) {
        // O(n) - time
        // O(1) - space

        // example [0,1,3] output = 2

        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        // 1 ^ 2 = 3
        // 3 ^ 3 = 0

        // 0 ^ 0 = 0
        // 0 ^ 1 = 1
        // 1 ^ 3 = 2

        // 0 ^ 2 = 2

        int totalXor = 0;
        int numsXor = 0;

        for (int i = 0; i <= nums.length; i++) {
            totalXor ^= i;
        }
        for (int i : nums) {
            numsXor ^= i;
        }

        return (totalXor ^ numsXor);
    }

    public static int getMissingNumber2(int[] nums) {
        // O(n) - time
        // 0(n) - space

        boolean[] status = new boolean[nums.length + 1];

        for (final int num : nums) {
            status[num] = true;
        }

        for (int i = 0; i < status.length; i++) {
            if (!status[i])
                return i;
        }

        return -1;
    }

    public static int getMissingNumber3(int[] nums) {
        // sort
        // n(nlogn) - time slower but less space
        // n(1) - space

        Arrays.sort(nums);

        if (nums[0] == 0 && nums.length == 1) {
            return 1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static int getMissingNumber4(int[] nums) {
        // O(n) - time
        // O(1) - space
        int totalSum = 0;
        for (final int num : nums) {
            totalSum += num;
        }
        return (totalSum / nums.length);
    }

    public static void main(String[] args) {
        int[] input = {0, 1, 3, 4};
        int[] input2 = {0, 1, 2, 3, 4, 6};
        // output is 2
        System.out.println(MissingNumber.getMissingNumber1(input));
        // output is 5
        System.out.println(MissingNumber.getMissingNumber2(input2));
        // output is 2
        System.out.println(MissingNumber.getMissingNumber3(input));
        // output is 5
        System.out.println(MissingNumber.getMissingNumber3(input2));
    }

}