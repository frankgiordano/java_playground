package leetcode;

import java.util.Arrays;

/*
Given an array containing n distinct numbers taken from 
0, 1, 2, ..., n, find the one that is missing from the array.
*/
public class missingNumber {

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
        
        for (int i = 0; i <= nums.length; i++)
            totalXor ^= i;
        for (int i: nums)
            numsXor ^= i;
        
        return (totalXor ^ numsXor);
    }

    public static int getMissingNumber2(int[] nums) {

        // O(n) - time
        // 0(n) - space

        boolean[] status = new boolean[nums.length+1];
        
        for (int i = 0; i < status.length; i++) {
            status[i] = false;
        }
        
        for (int i = 0; i < nums.length; i++) {
            status[nums[i]] = true;
        }
        
        for (int i = 0; i < status.length; i++) {
            if (status[i] == false)
                return i;
        }
        
        return -1;
    }

    public static int getMissingNumber3(int[] nums) {

        // sort
        // n(nlogn) - time slower but less space
        // n(1) - space

        Arrays.sort(nums);
        
        if (nums[0] == 0 && nums.length == 1)
            return 1;
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                continue;
            else if (nums[i] != i)
                return i;
        }

        return nums.length;
    }

    public static int getMissingNumber4(int[] nums) {

        // O(n) - time
        // O(1) - space

        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        return (totalSum/nums.length);
    }

    public static void main(String[] args) {

        int[] input = {0, 1, 3, 4};

        System.out.println(getMissingNumber1(input));
        System.out.println(getMissingNumber2(input));
        System.out.println(getMissingNumber3(input));
        System.out.println(getMissingNumber4(input));
    }

}