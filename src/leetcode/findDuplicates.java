package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

example [2, 1, 2, 1] = a
    
2 - 1 = 1
    index = 1
    a[1] = 1 is it visited less then 0? no = marked as -1

1 - 1 = 0
    index = 0
    a[0] = 2 is it visited less then 0? no = marked as -2
    
2 - 1 = 1
    index = 1
    a[1] = -1 is visited meaning less than 0 = duplicsate add to set 

    [-2, -1, 2, 1] = a
*/

public class findDuplicates {

    public static List<Integer> findDups(int[] nums) {
        Set<Integer> result = new HashSet<Integer>();
        
        // [2, 1, 2, 1] 
        for (int i = 0; i < nums.length; i++) {
             int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i])); 
            }
            else {
                nums[index] = -nums[index];   
            }
        }
        
        return new ArrayList(result);
    }

    public static void main (String args[]) {

        int[] input = {4,3,2,7,8,2,3,1};

        List<Integer> result = findDups(input);

        for (Integer i: result) 
            System.out.print(i + " ");
    }

}