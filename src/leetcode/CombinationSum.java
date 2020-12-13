package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://leetcode.com/problems/combination-sum/
39. Combination sum

Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen 
numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the frequency of at least one of the chosen numbers
is different.

It is guaranteed that the number of unique combinations that sum up to target
is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
*/
public class CombinationSum {

    private static List<List<Integer>> combinationSum(int[] input, int target) {
        List<List<Integer>> results = new ArrayList<>();

        if (input == null || input.length == 0) {
            return results;
        }

        List<Integer> combinations = new ArrayList<>();
        
        Arrays.sort(input);

        findCombinations(results, input, combinations, target, 0 );
        return results;
    }

    private static void findCombinations(List<List<Integer>> results, int[] input, List<Integer>
            combination, int target, int startIndex) {
        if (target == 0) {    
          results.add(new ArrayList<>(combination));
          return;
        }  

        for (int i = startIndex; i < input.length; i++) {
            if (input[i] > target)
                break;

            combination.add(input[i]);
            int newTarget = target - input[i];
            findCombinations(results, input, combination, newTarget, i);
            combination.remove(combination.size() - 1);
        }            
    } 

    public static void main(String[] args) {

        int[] input = { 2, 3, 6, 7};
        List<List<Integer>> results = combinationSum(input, 7);
        results.forEach(i -> {
            System.out.println(i);
        });
    }

}