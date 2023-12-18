/**
 * https://leetcode.com/problems/power-of-four/description/
 *
 * Output:
 * ------
 * false
 * true
 * false
 */

public class PowerOfFour {
public boolean isPowerOfFour(int n) {
        double val = Math.log10(n)/Math.log10(4);
        return ((val - (int)val) == 0)? true: false;
    }
    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(0));
        System.out.println(new PowerOfFour().isPowerOfFour(16));
        System.out.println(new PowerOfFour().isPowerOfFour(-16));
    }
}
