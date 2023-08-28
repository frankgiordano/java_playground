package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
 * Challenge 4: Array of Products of All Elements Except Itself
 *
 * Given an array, return an array where each index stores the product of all numbers except the number on the index itself.
 *
 * author francesco giordano
 */
public class CheckProduct {

    // brute force O(n^)
    public static int[] findProduct(int[] arr) {

        if (arr == null)
            return null;

        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int product = 1;
            for (int j = 0; j < arr.length; j++) {
                if (j != i)
                    product *= arr[j];
            }
            result[i] = product;
        }

        return result;
    }

    // O(n) from educative.io solution
    public static int[] findProduct2(int arr[]) {
        int n = arr.length;
        int i, temp = 1;

        // Allocation of result array
        int result[] = new int[n];

        // Initializing the result array by 1
        for (int j = 0; j < n; j++)
            result[j] = 1;

        // Product of elements on left side excluding arr[i]
        for (i = 0; i < n; i++) {
            result[i] = temp;
            temp *= arr[i];
        }

        // Initializing temp to 1 for product on right side
        temp = 1;

        // Product of elements on right side excluding arr[i] */
        for (i = n - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= arr[i];
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        arr = CheckProduct.findProduct2(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

}