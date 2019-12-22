package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.heap;

import java.util.Arrays;

/*
Max Heap implementation

author: educative.io

I made minor tweaks
*/
public class Heap {

    public static void buildMaxHeap(int[] arr) {
        int size = arr.length;

        for (int i = (size - 1) / 2; i >= 0; i--) {
            Heap.maxHeapify(arr, i, size);
        }

    } 

    public static void buildMinHeap(int[] arr) {
        int size = arr.length;

        for (int i = (size -1) / 2; i >= 0; i--) {
            Heap.minHeapify(arr, i, size);
        }
    }

    private static void minHeapify(int[] heapArr, int index, int heapSize) {
        int min = index;

        while (min < (heapSize) / 2) {
            int left = (2 * index) + 1;
            int right = (2 * index) + 2;

            if (left < heapSize && heapArr[left] < heapArr[min])
                min = left;

            if (right < heapSize && heapArr[right] < heapArr[min])
                min = right;

            if (min != index) {
                int tmp = heapArr[index];
                heapArr[index] = heapArr[min];
                heapArr[min] = tmp;
                index = min;
            } else {
                break;
            }
        }
    }

    private static void maxHeapify(int[] heapArr, int index, int heapSize) {
        int largest = index;

        // check parent nodes only
        while (largest < (heapSize / 2)) {
            // get left child
            int left = (2 * index) + 1;
            // get right child
            int right = (2 * index) + 2;

            if (left < heapSize && heapArr[left] > heapArr[largest]) {
                largest = left;
            }

            if (right < heapSize && heapArr[right] > heapArr[largest]) {
                largest = right;
            }

            // swap parent
            if (largest != index) {
                int tmp = heapArr[index];
                heapArr[index] = heapArr[largest];
                heapArr[largest] = tmp;
                index = largest;
            } else {
                break;
            }

        }

    }

    public static void main(String[] args) {
        int[] heapArray1 = { 1, 2, 3, 4, 7, 8, 9, 12, 56 };
        int[] heapArray2 = { 56, 12, 9, 8, 7, 4, 3, 2, 1 };

        System.out.println("Before becoming max heap " + Arrays.toString(heapArray1));
        Heap.buildMaxHeap(heapArray1);
        System.out.println("Before becoming max heap " + Arrays.toString(heapArray1));

        System.out.println("Before becoming min heap " + Arrays.toString(heapArray2));
        Heap.buildMinHeap(heapArray2);
        System.out.println("Before becoming min heap " + Arrays.toString(heapArray2));
    }

}