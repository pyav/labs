/**
 * https://leetcode.com/problems/ugly-number/
 *
 * Output:
 * ------
 * false
 * true
 * true
 * false
 * false
 * false
 */

public class UglyNumber {
    public boolean isUgly(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n%2 == 0) {
            n = n/2;
        } else if (n%3 == 0) {
            n = n/3;
        } else if (n%5 == 0) {
            n = n/5;
        } else {
            return false;
        }
        return isUgly(n);
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().isUgly(0));
        System.out.println(new UglyNumber().isUgly(6));
        System.out.println(new UglyNumber().isUgly(1));
        System.out.println(new UglyNumber().isUgly(14));
        System.out.println(new UglyNumber().isUgly(2147483647));
        System.out.println(new UglyNumber().isUgly(-2147483648));
    }
}

