package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
 * Challenge 11: Find the Sum of Maximum Sum Subarray
 *
 * Given an unsorted array AA, the maximum sum sub-array is the sub-array (contiguous elements) from AA
 * for which the sum of the elements is maximum. In this challenge, we want to find the sum of the
 * maximum sum sub-array. This problem is a tricky one because the array might have negative integers
 * in any position, so we have to cater to those negative integers while choosing the contiguous
 * subarray with the largest positive values..
 *
 * author francesco giordano
 */
public class CheckMaxSumSubArray {

    public static int getMaxSumSubArray(int[] arr) {
        // time (O)n2 space (O)1
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int maxSum = arr[0];
        int sum;
        for (int i = 0; i < arr.length; i++) {
            sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }

        return maxSum;
    }

    public static int getMaxSumSubArray2(int[] arr) {
        // time (O)n space (O)1
        if (arr == null || arr.length == 0) {
            return 0;
        }

        if (arr.length == 1) {
            return arr[0];
        }

        int currMax = arr[0];
        int globalMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (currMax < 0) {
                currMax = arr[i];
            } else {
                currMax = currMax + arr[i];
            }

            if (globalMax < currMax) {
                globalMax = currMax;
            }
        }

        return globalMax;
    }

    public static void main(String[] args) {
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray(new int[]{1, 7, -2, -5, 10, -1}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray(new int[]{-7, 6, -2}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray(new int[]{5, 4, -1, 7, 8}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray(new int[]{-2, -1}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray2(new int[]{1, 7, -2, -5, 10, -1}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray2(new int[]{-7, 6, -2}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray2(new int[]{5, 4, -1, 7, 8}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(CheckMaxSumSubArray.getMaxSumSubArray2(new int[]{-2, -1}));
    }

}
