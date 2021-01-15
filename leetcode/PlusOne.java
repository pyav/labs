/**
 * https://leetcode.com/problems/plus-one/
 *
 * Output:
 * ------
 * 1
 * 2
 * 4
 */

package leetcode;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int[] result = new int[1+len];
        int carry = 0;
        int i;
        if (digits[len-1] != 9) {
            digits[len-1] += 1;
            return digits;
        } else {
            carry = 1;
            i=len-1;
            while(carry!=0 && i>=0) {
                carry = (digits[i]+1)/10;
                digits[i] = (digits[i]+1)%10;
                result[i+1] = digits[i];
                i--;
            }
            if (carry!=0) {
                result[0] = 1;
                return result;
            } else {
                result[0] = 0;
                return digits;
            }
        }
    }

    public static void main(String[] args) {
        int[] digits = {1, 2, 3};
        int[] result = new PlusOne().plusOne(digits);
        System.out.println(result[0]);
        System.out.println(result[1]);
        System.out.println(result[2]);
    }
}

