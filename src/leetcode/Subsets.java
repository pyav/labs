/**
 * https://leetcode.com/problems/subsets/
 *
 * Output:
 * ------
 * 
 * 1 
 * 2 
 * 1 2 
 * 3 
 * 1 3 
 * 2 3 
 * 1 2 3
 */

import java.util.List;
import java.util.ArrayList;

public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        int totalLists = 1 << n;

        for (int i = 0; i < totalLists; i++) {
            int j = i;
            int k = 0;
            List<Integer> list = new ArrayList<Integer>();
            while(j != 0) {
                if ((j&1) == 1) {
                    list.add(nums[k]);
                }

                j = j >> 1;
                k++;
            }
            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

