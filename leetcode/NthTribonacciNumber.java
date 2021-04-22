/**
 * https://leetcode.com/problems/n-th-tribonacci-number/
 *
 * Output:
 * ------
 * 1
 * 1
 * 2
 * 4
 * 7
 */

package leetcode;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int c  = 1;
            int d = 0;
            for (int i = 3; i <= n; i++) {
                d = a+b+c;
                a = b;
                b = c;
                c = d;
            }
            return d;
        }
    }

    public static void main(String[] args) {
        System.out.println(new NthTribonacciNumber().tribonacci(1));
        System.out.println(new NthTribonacciNumber().tribonacci(2));
        System.out.println(new NthTribonacciNumber().tribonacci(3));
        System.out.println(new NthTribonacciNumber().tribonacci(4));
        System.out.println(new NthTribonacciNumber().tribonacci(5));
    }

}

