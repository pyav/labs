/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * Output:
 * ------
 * 0
 * 1
 * 1
 * 2
 * 3
 * 5
 * 8
 * 13
 */

package leetcode;

public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            int a = 0;
            int b = 1;
            int c = 0;
            for (int i = 2; i <= n; i++) {
                c = a+b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new FibonacciNumber().fib(0));
        System.out.println(new FibonacciNumber().fib(1));
        System.out.println(new FibonacciNumber().fib(2));
        System.out.println(new FibonacciNumber().fib(3));
        System.out.println(new FibonacciNumber().fib(4));
        System.out.println(new FibonacciNumber().fib(5));
        System.out.println(new FibonacciNumber().fib(6));
        System.out.println(new FibonacciNumber().fib(7));
    }

}

