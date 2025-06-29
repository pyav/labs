/**
 * https://leetcode.com/problems/multiply-strings/description/?envType=problem-list-v2&envId=string
 *
 * Output:
 * ------
 * 6
 * 396
 * 0
 * 13200000000120000000012000000001200000000120000000012000000001200000000120000000012000000000000000000
 * 81
 */

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        if ((num1.length() == 1 && num1.charAt(0) == '0')
            || (num2.length() == 1 && num2.charAt(0) == '0')) {
            return "0";
        }

        String maxLenNum = new String();
        String minLenNum = new String();

        if (num1.length() > num2.length()) {
            maxLenNum = num1;
            minLenNum = num2;
        } else {
            maxLenNum = num2;
            minLenNum = num1;
        }

        maxLenNum = new StringBuilder(maxLenNum).reverse().toString();
        minLenNum = new StringBuilder(minLenNum).reverse().toString();

        int carry = 0;
        String result = new String();

        for (int i = 1; i <= minLenNum.length(); i++) {
            int val = 0;
            for (int j = 0; j < i; j++) {
                val += (minLenNum.charAt(j) - '0') * (maxLenNum.charAt(i-j-1) - '0');
            }
            val += carry;
            result += Integer.toString(val%10);
            carry = val/10;
        }

        for (int i = 1; i <= maxLenNum.length() - minLenNum.length(); i++) {
            int val = 0;
            for (int j = 0; j < minLenNum.length(); j++) {
                val += ((minLenNum.charAt(j) - '0') * (maxLenNum.charAt(i + minLenNum.length() - j - 1) - '0'));
            }
            val += carry;
            result += Integer.toString(val%10);
            carry = val/10;
        }

        for (int i = minLenNum.length()-1; i >= 1; i--) {
            int val = 0;
            for (int j = minLenNum.length()-1; j >= minLenNum.length()-i; j--) {
                val += (minLenNum.charAt(j) - '0') * (maxLenNum.charAt(maxLenNum.length() - i + minLenNum.length() - j - 1) - '0');
            }
            val += carry;
            result += Integer.toString(val%10);
            carry = val/10;
        }
        if (carry > 0) {
            result += Integer.toString(carry);
        }

        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("2", "3"));
        System.out.println(new MultiplyStrings().multiply("12", "33"));
        System.out.println(new MultiplyStrings().multiply("0", "34444"));
        System.out.println(new MultiplyStrings().multiply("1100000000010000000001000000000100000000010000000001000000000100000000010000000001000000000000000000", "12"));
        System.out.println(new MultiplyStrings().multiply("9", "9"));
    }
}

