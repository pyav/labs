/**
 * https://leetcode.com/problems/subsets-ii/
 *
 * Output:
 * ------
 * 
 * 4 
 * 4 4 
 * 4 4 4 
 * 1 
 * 1 4 
 * 1 4 4 
 * 1 4 4 4 
 * 4 4 4 4 
 * 1 4 4 4 4 
 */

import java.util.*;

public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int n = nums.length;
        int totalLists = 1 << n;
        Set<String> runStrSet = new HashSet<String>();

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
            Collections.sort(list);
            String runStr = "";
            for (Integer item : list) {
            	runStr += " " + String.valueOf(item);
            }
            if (!runStrSet.contains(runStr.trim())) {
                result.add(list);
                runStrSet.add(runStr.trim());
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,4,4,1,4};
        List<List<Integer>> result = new SubsetsII().subsetsWithDup(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

