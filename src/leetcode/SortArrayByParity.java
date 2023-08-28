package leetcode;

/*
https://leetcode.com/problems/sort-array-by-parity/submissions/
905. Sort Array By Parity

Given an array A of non-negative integers, return an array consisting of all
the even elements of A, followed by all the odd elements of A.

You may return any answer array that satisfies this condition.

Example 1:

Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.

author francesco giordano
 */
public class SortArrayByParity {

    public static int[] sortArrayByParity(int[] A) {

        int i1 = 0;
        int i2 = A.length - 1;

        while (i1 < i2) {
            if (A[i1] % 2 != 0 && A[i2] % 2 == 0) {
                int tmp = A[i1];
                A[i1] = A[i2];
                A[i2] = tmp;
            }

            if (A[i1] % 2 == 0)
                i1++;

            if (A[i2] % 2 != 0)
                i2--;
        }

        return A;
    }

    public static void output(int[] input) {
        SortArrayByParity.sortArrayByParity(input);
        for (int i : input)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input = {3, 1, 2, 4};
        SortArrayByParity.output(SortArrayByParity.sortArrayByParity(input));
        int[] input2 = {0, 1, 2};
        SortArrayByParity.output(SortArrayByParity.sortArrayByParity(input2));
    }

}
