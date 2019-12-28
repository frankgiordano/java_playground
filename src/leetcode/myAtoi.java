package leetcode;

/*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the
first non-whitespace character is found. Then, starting from this character, takes
an optional initial plus or minus sign followed by as many numerical digits as possible,
and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number,
which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number,
or if no such sequence exists because either str is empty or it contains only whitespace
characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

author: francesco giordano
*/
public class MyAtoi {
    public static int atoi(String str) {
        str = str.trim();
        if (isValid(str) == false)
            return 0;

        str = convertToValidString(str);

        return convertStringToNum(str);
    }

    private static int convertStringToNum(String str) {

        if (str.length() == 0)
            return 0;

        int num = 0;

        if (str.charAt(0) == '-' || str.charAt(0) == '+') {

            if (str.length() == 1)
                return 0;
            // minus = true;
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return Integer.MAX_VALUE + 1;
            }
        } else {
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return Integer.MAX_VALUE;
            }
        }

        return num;
    }

    private static boolean isValid(String s) {
        s = s.trim();
        if (s.length() == 0)
            return false;

        char firstChar = s.charAt(0);
        char secondChar = 0;

        if (s.length() > 1)
            secondChar = s.charAt(1);

        if (firstChar > 39 && firstChar < 58)
            return true;

        if ((firstChar == '-' || firstChar == '+') && !(secondChar == '-' || secondChar == '+')) {
            return true;
        } else
            return false;
    }

    private static String convertToValidString(String s) {
        char[] num = new char[s.length()];
        String result;

        boolean foundMinusOrPlus = false;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            foundMinusOrPlus = true;
            num[0] = s.charAt(0);
        }

        int j = 0;
        int i = 0;
        if (foundMinusOrPlus == true) {
            i = 1;
            j = 1;
        }

        for (; i < s.length(); i++) {

            if (s.charAt(i) == ' ' || s.charAt(i) == '.' || !(s.charAt(i) > '0' && s.charAt(i) < '9'))
                break;

            if (s.charAt(i) > '0' && s.charAt(i) < '9') {
                num[j++] = s.charAt(i);
            }

        }

        result = new String(num);
        return result.trim();
    }

    public static void main(String[] args) {
        System.out.println(MyAtoi.atoi("-214748-3648"));
    }
}
