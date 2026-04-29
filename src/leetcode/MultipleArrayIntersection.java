/**
 * https://leetcode.com/problems/intersection-of-multiple-arrays/
 *
 * Output:
 * ------
 * 3 4 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class MultipleArrayIntersection {
    public List<Integer> intersection(int[][] nums) {
        int[] count = new int[1000];
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                count[nums[i][j] - 1]++;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            if (count[i] == n) {
                result.add(i+1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{3,4,5,6}, {1,2,3,4}, {3,1,2,4,5}};
        List<Integer> result = new MultipleArrayIntersection().intersection(nums);
        result.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println();

        int[][] nums2 = {{1,2,3}, {4,5,6}};
        List<Integer> result2 = new MultipleArrayIntersection().intersection(nums2);
        result2.stream().forEach(x -> System.out.printf("%d ", x));
        System.out.println();

    }
}

