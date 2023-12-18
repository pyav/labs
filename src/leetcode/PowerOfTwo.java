/**
 * https://leetcode.com/problems/power-of-two/description/
 *
 * Output:
 * ------
 * true
 * true
 * false
 * false
 * false
 * false
 */

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        double val = Math.log10(n)/Math.log10(2);
        return ((val - (int)val) == 0)? true: false;
    }
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
        System.out.println(new PowerOfTwo().isPowerOfTwo(16));
        System.out.println(new PowerOfTwo().isPowerOfTwo(3));
        System.out.println(new PowerOfTwo().isPowerOfTwo(0));
        System.out.println(new PowerOfTwo().isPowerOfTwo(-3));
        System.out.println(new PowerOfTwo().isPowerOfTwo(-4));
    }
}

