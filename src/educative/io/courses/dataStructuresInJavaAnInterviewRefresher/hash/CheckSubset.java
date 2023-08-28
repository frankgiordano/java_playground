package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashSet;

/*
Challenge 1: Find whether an array is a subset of another array

Can you find whether a given array is a subset of another by using a built-in Hash Table?
A solution is placed in the "solution" section to help you, but we would suggest you try 
to solve it on your own first.

author: francesco giordano
*/
class CheckSubset {

    public static boolean isSubset(int[] arr1, int[] arr2) {
        // time O(n + m). space O(n)
        HashSet<Integer> set = new HashSet<Integer>();

        for (int value : arr1) {   // O(n)
            set.add(Integer.valueOf(value));
        }

        for (int value : arr2) {   // O(m)
            if (!set.contains(value))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 4};

        System.out.println(CheckSubset.isSubset(arr1, arr2));
    }

}