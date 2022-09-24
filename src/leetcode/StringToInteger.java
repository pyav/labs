/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 *
 * Output:
 * ------
 * 32
 * -32
 * 0
 * 0
 * -2147483648
 * 0
 * 0
 * 0
 * 0
 * -2147483648
 * -13
 * 13
 * 123
 * 123
 * 0
 */

public class StringToInteger {

    public int myAtoi(String s) {
        int len = s.length();
        int num = 0;
        boolean isNegative = false;
        boolean isPlusPresent = false;
        boolean numStart = false;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == ' ') {
                if (numStart) {
                    break;
                }
                continue;
            }
            if (s.charAt(i) == '-') {
                if (isPlusPresent) {
                    if (numStart) {
                        break;
                    }
                    num = 0;
                    break;
                }
                if (numStart) {
                    break;
                }
                isNegative = true;
                numStart = true;
                continue;
            }
            if (s.charAt(i) == '+') {
                if (isNegative) {
                    if (numStart) {
                        break;
                    }
                    num = 0;
                    break;
                }
                if (numStart) {
                    break;
                }
                isPlusPresent = true;
                numStart = true;
                continue;
            }
            if (s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
                numStart = true;
                long calcVal = (long)num * 10 + (s.charAt(i) - '0');
                if (calcVal > Integer.MAX_VALUE) {
                    num = (int) Math.pow(2, 31);
                    if (isNegative) {
                        num += 1;
                    }
                    break;
                }
                num = num * 10 + (s.charAt(i) - '0');
                continue;
            }
            break;
        }
        if (isNegative) {
            num *= -1;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new StringToInteger().myAtoi("0032 with words"));
        System.out.println(new StringToInteger().myAtoi("-0032 with words"));
        System.out.println(new StringToInteger().myAtoi("00-32 with words 23"));
        System.out.println(new StringToInteger().myAtoi("00-32.with words 23"));
        System.out.println(new StringToInteger().myAtoi("-91283472332"));
        System.out.println(new StringToInteger().myAtoi("+-12"));
        System.out.println(new StringToInteger().myAtoi("-+12"));
        System.out.println(new StringToInteger().myAtoi("00000-42a1234"));
        System.out.println(new StringToInteger().myAtoi("   +0 123"));
        System.out.println(new StringToInteger().myAtoi("-6147483648"));
        System.out.println(new StringToInteger().myAtoi("-13+8"));
        System.out.println(new StringToInteger().myAtoi("+13-8"));
        System.out.println(new StringToInteger().myAtoi("123-"));
        System.out.println(new StringToInteger().myAtoi("+123-"));
        System.out.println(new StringToInteger().myAtoi("  +  413"));
    }

}

