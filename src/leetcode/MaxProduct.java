/**
 * https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/description/
 *
 * Output:
 * ------
 * 12
 * 16
 * 12
 */

public class MaxProduct {
    public int maxProduct(int[] nums) {
        int max = 0;
        int secondMax = 0;

        for (int num : nums) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax) {
                secondMax = num;
            }
        }

        return (max - 1) * (secondMax - 1);
    }

    public static void main(String[] args) {
        System.out.println(new MaxProduct().maxProduct(new int[]{3,4,5,2}));
        System.out.println(new MaxProduct().maxProduct(new int[]{1,5,4,5}));
        System.out.println(new MaxProduct().maxProduct(new int[]{3,7}));
    }
}

