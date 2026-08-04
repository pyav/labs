/**
 * https://leetcode.com/problems/sqrtx/description/
 *
 * Output:
 * ------
 * 2
 * 1
 * 3
 * 0
 */

public class Sqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }
        int left = 1, right = x / 2, ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(4));
        System.out.println(new Sqrt().mySqrt(1));
        System.out.println(new Sqrt().mySqrt(11));
        System.out.println(new Sqrt().mySqrt(0));
    }

}