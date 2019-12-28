package leetcode;

public class UglyNumber {

    public static boolean isUgly(int num) {
        if (num == 0)
            return false;
        if (num == 1)
            return true;

        if (num % 2 == 0) {
            num = num / 2;
            return isUgly(num);
        }

        if (num % 3 == 0) {
            num = num / 3;
            return isUgly(num);
        }

        if (num % 5 == 0) {
            num = num / 5;
            return isUgly(num);
        }

        return false;
    }
    
    public static void main (String[] args) {
        System.out.println(" is ugly = " + UglyNumber.isUgly(6));
    }

}