/**
 * https://leetcode.com/problems/sum-of-all-subset-xor-totals/
 *
 * Output:
 * ------
 * 28
 * 480
 */

import java.util.List;
import java.util.ArrayList;

public class SumAllSubsetXor {

    private List<List<Integer>> subsets(int[] nums) {
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

    public int subsetXORSum(int[] nums) {
        List<List<Integer>> result = subsets(nums);
        int sum = 0;
        for (List<Integer> list : result) {
            if (list.size() > 0) {
                int xor = 0;
                for (Integer item : list) {
                    xor = xor ^ item;
                }
                sum += xor;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(new SumAllSubsetXor().subsetXORSum(nums));
        int[] nums2 = {3,4,5,6,7,8};
        System.out.println(new SumAllSubsetXor().subsetXORSum(nums2));
    }

}

