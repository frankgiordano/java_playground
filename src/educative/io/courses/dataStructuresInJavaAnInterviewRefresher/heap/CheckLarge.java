package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.heap;

import java.util.Arrays;

/*
Challenge 3: Find the k Largest Elements in an Array
If you are given an array and any number "k", can you 
write a code to find the "k" largest elements using a Max Heap?

author: francesco giordano
*/
public class CheckLarge {

    public static int[] findKSmallest(int[] arr, int k) {
        int size = arr.length;

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = CheckLarge.removeMin(arr, size--);
        }

        return result;
    }

    private static int removeMin(int[] arr, int size) {
        CheckLarge.buildMaxHeap(arr, size);
        int result = arr[0];
        arr[0] = arr[size - 1];
        return result;
    }

    private static void buildMaxHeap(int[] arr, int size) {
        for (int i = (size - 1) / 2; i >= 0; i--) {
            CheckLarge.maxHeapify(arr, i, size);
        }
    }

    private static void maxHeapify(int[] heapArr, int index, int heapSize) {
        int max = index;

        while (max < (heapSize) / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && heapArr[left] > heapArr[max])
                max = left;

            if (right < heapSize && heapArr[right] > heapArr[max])
                max = right;

            if (max != index) {
                int tmp = heapArr[index];
                heapArr[index] = heapArr[max];
                heapArr[max] = tmp;
                index = max;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

        int[] heapArray = {56, 12, 9, 8, 7, 4, 3, 2, 1};
        int[] heapArray2 = {9, 4, 7, 1, -2, 6, 5};

        System.out.println("Array = " + Arrays.toString(heapArray));
        int[] result = CheckLarge.findKSmallest(heapArray, 3);
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
        System.out.println();
        System.out.println("Array = " + Arrays.toString(heapArray2));
        int[] result2 = CheckLarge.findKSmallest(heapArray2, 3);
        for (int i = 0; i < result2.length; i++)
            System.out.println(result2[i]);
    }

}