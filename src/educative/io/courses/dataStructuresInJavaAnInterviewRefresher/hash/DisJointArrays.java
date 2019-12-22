package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.hash;

import java.util.HashSet;
import java.util.Set;


/*
Challenge 2: Check if the given arrays are disjoint

If you are given two arrays, arr1 and arr2, can you check if
these arrays are disjoint? A solution is placed in the "solution" 
section to help you, but we would suggest you try to solve it on your own first.

author: francesco giordano
*/
class DisJointArrays {

    public static boolean isDisjoint(int[] arr1, int[] arr2) {
        // time O(n+m) time, space O(n) 
        Set<Integer> set = new HashSet<Integer>();

        for (int i: arr1) {
            set.add(i);
        }

        for (int j: arr2) {
            if (set.contains(j))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] arr1 = {9,4,3,1,-2,6,5};
        int[] arr2 = {7,10,8};

        System.out.println(DisJointArrays.isDisjoint(arr1, arr2));
    }    

}