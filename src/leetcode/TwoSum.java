package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/
1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a
specific target.

You may assume that each input would have exactly one solution, and you may not use the
same element twice.

author: francesco giordano
 */
public class TwoSum {

    public static int[] getTwoSum(int[] nums, int target) {

        // time = O(n2)
        // space = O(1)

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (j == i)
                    continue;

                int sum = nums[i] + nums[j];
                if (sum == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public static int[] getTwoSum2(int[] nums, int target) {

        // time = O(n)
        // space = O(n)

        Map<Integer, Integer> numMap = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int value = target - nums[i];
            if (numMap.containsKey(value) && numMap.get(value) != i) {
                result[0] = i;
                result[1] = numMap.get(value);
                return result;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] input = { 2, 7, 11, 15 };

        input = TwoSum.getTwoSum(input, 9);
        for (int i : input) {
            System.out.println(i);
        }
        System.out.println();
        int[] input2 = { 3, 2, 4 };
        input2 = TwoSum.getTwoSum2(input2, 6);
        for (int i : input2) {
            System.out.println(i);
        }

    }

}
