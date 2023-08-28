package leetcode;

/*
Given an array containing n distinct numbers taken from 
0, 1, 2, ..., n, find the two nums that are missing from the array.

author francesco giordano
*/
public class TwoMissingNumbers {

    public static int[] getTwoMissingNumber(int[] nums) {
        // it is missing two entries add two to total size
        int size = nums.length + 2;
        long totalSum = (long) size * (size + 1) / 2;

        long numsSum = 0;
        for (int i : nums)
            numsSum += i;

        int pivot = (int) ((totalSum - numsSum) / 2);

        int totalXorLeft = 0;
        int totalXorRight = 0;

        for (int i = 0; i <= pivot; i++)
            totalXorLeft ^= i;

        for (int i = pivot + 1; i <= size; i++)
            totalXorRight ^= i;

        int numsXorLeft = 0;
        int numsXorRight = 0;

        for (int i : nums) {
            if (i <= pivot) {
                numsXorLeft ^= i;
            } else {
                numsXorRight ^= i;
            }
        }

        return new int[]{totalXorLeft ^ numsXorLeft, totalXorRight ^ numsXorRight};
    }

    public static void main(String[] args) {
        int[] input = {1, 2, 4, 6};
        int[] result = TwoMissingNumbers.getTwoMissingNumber(input);

        for (int i : result)
            System.out.print(i + " ");
    }

}