package codility;

/*
 *  Fix the following code. Note: Data set limited to 100000.
 */
public class fixLessThanValue {

    public static int solution(int[] A) {
        int ans = 0;
        // for (int i = 1; i < A.length; i++) {   // original for statement
        for (int i = 0; i < A.length && i < 100000; i++) {  // amended fix 
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 1, -2, 2};
        System.out.println(fixLessThanValue.solution(arr));
    }

}