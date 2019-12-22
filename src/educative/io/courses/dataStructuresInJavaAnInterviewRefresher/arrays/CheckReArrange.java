package educative.io.courses.dataStructuresInJavaAnInterviewRefresher.arrays;

/*
Challenge 9: Re-arrange Positive & Negative Values

Given an array, can you re-arrange its elements in such a way that the negative
elements appear at one side and positive elements appear at the other? Solve this
problem in Java and see if your code runs correctly!

author: francesco giordano
*/
public class CheckReArrange {

    public static void reArrange1(int[] arr) { 
        // time n+n+n = 3n = O(n)
        // space O(1)

        if (arr == null) 
            return;

        int size = arr.length;

        int[] result = new int[size];

        int index = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] < 0) 
                result[index++] = arr[i];
        }

        for (int i = 0; i < size; i++) {
            if (arr[i] > 0) 
                result[index++] = arr[i];
        }

        for (int i = 0; i < size; i++) {
            arr[i] = result[i];
        }

    }

    public static void reArrange2(int[] arr) { 
        // time O(n)
        // space O(1)

        if (arr == null) 
            return;

        int size = arr.length;

        int j = 0;
        for (int i = 0; i < size; i++) {
            if (i != j) {
                if (arr[i] < 0) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
        }   
        }

    }

    public static void main(String args[]) {
        int[] arr = { -1, 2, 3, -5, -3, -10, 7 };

        CheckReArrange.reArrange1(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();

        CheckReArrange.reArrange1(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}