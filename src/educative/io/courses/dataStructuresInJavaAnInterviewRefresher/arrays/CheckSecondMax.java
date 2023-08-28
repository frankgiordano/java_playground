package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
 * Challenge 7: Find Second Maximum Value in an Array
 *
 * Given an array of size n, can you find the second maximum element in the array?
 *
 * author francesco giordano
 */
public class CheckSecondMax {

    public static int findSecondMaximum(int[] arr) {
        // O(n) time
        int max1 = -1;
        int max2 = -1;

        if (arr == null) {
            return max2;
        }

        for (final int j : arr) {
            if (max1 < j) {
                max2 = max1;
                max1 = j;
            } else if (max2 < j) {
                max2 = j;
            }
        }

        return max2;
    }

    public static int findSecondMaximum2(int[] arr) {
        // n + n = O(n) time
        int max1 = -1;
        int max2 = -1;

        if (arr == null) {
            return max2;
        }

        for (final int j : arr) {
            if (max1 < j)
                max1 = j;
        }

        for (final int j : arr) {
            if (max1 != j && max2 < j)
                max2 = j;
        }

        return max2;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 3, 6};
        System.out.println(CheckSecondMax.findSecondMaximum(arr));
        System.out.println(CheckSecondMax.findSecondMaximum2(arr));
    }

}