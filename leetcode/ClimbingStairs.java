/**
 * https://leetcode.com/problems/climbing-stairs/
 *
 * Output:
 * ------
 * 1
 * 2
 * 3
 * 5
 * 8
 * 13
 */

package leetcode;

public class ClimbingStairs {

    int climbStairs(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int a = 1;
            int b = 2;
            int c = 0;
            for (int i = 3; i <= n; i++) {
                c = a+b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingStairs().climbStairs(1));
        System.out.println(new ClimbingStairs().climbStairs(2));
        System.out.println(new ClimbingStairs().climbStairs(3));
        System.out.println(new ClimbingStairs().climbStairs(4));
        System.out.println(new ClimbingStairs().climbStairs(5));
        System.out.println(new ClimbingStairs().climbStairs(6));
    }

}

