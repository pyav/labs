/**
 * https://leetcode.com/problems/count-number-of-maximum-bitwise-or-subsets/
 *
 * Output:
 * ------
 * 6
 */

import java.util.*;

public class MaxBitwiseOr {

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int totalLists = 1 << n;
        int maxOrVal = Integer.MIN_VALUE;
        int countMaxOr = 0;

        for (int i = 0; i < totalLists; i++) {
            int j = i;
            int k = 0;
            int runningOr = 0;
            while(j != 0) {
                if ((j&1) == 1) {
                    runningOr |= nums[k];
                }

                j = j >> 1;
                k++;
            }
            if (runningOr > maxOrVal) {
                countMaxOr = 1;
                maxOrVal = runningOr;
            } else if (runningOr == maxOrVal) {
                countMaxOr += 1;
            }
        }

        return countMaxOr;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5};
        //int[] nums = {2, 2, 2};
        //int[] nums = {3, 1};
        System.out.println(new MaxBitwiseOr().countMaxOrSubsets(nums));
    }

}
