/**
 * https://leetcode.com/problems/power-of-three/
 *
 * Output:
 * ------
 * false
 * true
 * true
 * true
 * true
 * false
 * false
 * false
 */

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        double val = Math.log10(n)/Math.log10(3);
        return ((val - (int)val) == 0)? true: false;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(0));
        System.out.println(new PowerOfThree().isPowerOfThree(3));
        System.out.println(new PowerOfThree().isPowerOfThree(27));
        System.out.println(new PowerOfThree().isPowerOfThree(81));
        System.out.println(new PowerOfThree().isPowerOfThree(243));
        System.out.println(new PowerOfThree().isPowerOfThree(32));
        System.out.println(new PowerOfThree().isPowerOfThree(-27));
        System.out.println(new PowerOfThree().isPowerOfThree(-10));
    }
}

