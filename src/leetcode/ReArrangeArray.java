/**
 * https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
 *
 * Output:
 * ------
 * 3 -2 1 -5 2 -4 
 * 1 -1
 */

import java.util.Arrays;

public class ReArrangeArray {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int pos = 0, neg = 1;
        for (int num : nums) {
            if (num > 0) {
                result[pos] = num;
                pos += 2;
            } else {
                result[neg] = num;
                neg += 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new ReArrangeArray().rearrangeArray(new int[]{3,1,-2,-5,2,-4});
        Arrays.stream(result).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
        int[] result2 = new ReArrangeArray().rearrangeArray(new int[]{-1, 1});
        Arrays.stream(result2).forEach(x -> System.out.printf("%d ", x));
        System.out.println();
    }
}

