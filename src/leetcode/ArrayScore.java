/**
 * https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/description/
 *
 * Otuput:
 * ------
 * 7
 * 5
 */

package leetcode;

import java.util.*;

public class ArrayScore {
    public long findScore(int[] nums) {
        int n = nums.length;
        TreeMap<Integer, List<Integer>> valueToIndices = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            valueToIndices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        boolean[] marked = new boolean[n];
        long sum = 0;

        for (Map.Entry<Integer, List<Integer>> entry : valueToIndices.entrySet()) {
            for (int idx : entry.getValue()) {
                if (!marked[idx]) {
                    sum += nums[idx];
                    marked[idx] = true;
                    if (idx - 1 >= 0) marked[idx - 1] = true;
                    if (idx + 1 < n) marked[idx + 1] = true;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3,4,5,2};
        System.out.println(new ArrayScore().findScore(nums));
        int[] nums2 = {2,3,5,1,3,2};
        System.out.println(new ArrayScore().findScore(nums2));
    }
}

