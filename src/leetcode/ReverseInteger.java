/**
 * https://leetcode.com/problems/reverse-integer/
 *
 * Output:
 * ------
 * 1
 * 201
 * -1
 * -321
 * 21
 * 0
 * 0
 */

package leetcode;

public class ReverseInteger {
   
    public int reverse(int x) {
        int result = 0;
        boolean isNegative = (x<0)? true: false;
        if (isNegative) {
            x*=-1;
        }
        double val = 0;
        while(x!=0) {
            val = (double) result*10+(x%10);
            result = result*10+(x%10);
            x/=10;
            if (val != result) {
                return 0;
            }
        }
        return (isNegative)? -1*result: result;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(100));
        System.out.println(new ReverseInteger().reverse(102));
        System.out.println(new ReverseInteger().reverse(-100));
        System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(120));
        System.out.println(new ReverseInteger().reverse(1534236469));
        System.out.println(new ReverseInteger().reverse(2147483647));
    }

}

