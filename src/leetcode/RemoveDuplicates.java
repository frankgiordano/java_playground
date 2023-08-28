package leetcode;

import java.util.Iterator;
import java.util.LinkedHashSet;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/
26. Remove Duplicates from Sorted Array

Given a sorted array nums, remove the duplicates in-place such that each element appear only once and
return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array
in-place with O(1) extra memory.

author francesco giordano
 */
public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        // space O(n)
        // time O(n+m)
        // this is slow compare to the method below
        LinkedHashSet<Integer> uniqueNums = new LinkedHashSet<>();
        for (Integer num : nums)
            uniqueNums.add(num);

        Iterator<Integer> itr = uniqueNums.iterator();
        int index = 0;
        while (itr.hasNext()) {
            nums[index++] = itr.next();
        }

        return index;
    }

    public static int removeDuplicates2(int[] nums) {
        // space O(1)
        // time O(n)

        // this is a perfect solution to use the two pointer method...
        // with slow and fast pointers.
        // fast pointer will expand and keep on looking ahead until it finds
        // a number not equal to the current slow pointer and this will be
        // non-duplicate... which at this point perform a replacement of the
        // item at slow++ and search via fast point for the next one.
        if (nums.length == 1)
            return 1;

        int fastIndex = 1;
        int slowIndex = 0;
        while (fastIndex < nums.length) {
            if (nums[slowIndex] != nums[fastIndex]) {
                slowIndex++;
                nums[slowIndex] = nums[fastIndex];
            }
            fastIndex++;
        }

        return slowIndex + 1;
    }

    public static void main(String[] args) {
        int[] input = {1, 1, 2, 2, 3, 4, 5, 5};
        int len;
        len = RemoveDuplicates.removeDuplicates(input);
        for (int i = 0; i < len; i++) {
            System.out.println(input[i]);
        }
        System.out.println();
        int[] input2 = {1, 1, 2, 2, 3, 4, 5, 5};
        len = RemoveDuplicates.removeDuplicates2(input2);
        for (int i = 0; i < len; i++) {
            System.out.println(input2[i]);
        }
    }

}
