/**
 * https://leetcode.com/problems/permutations-ii/
 *
 * Output:
 * ------
 * 1 2 3 
 * 3 2 1 
 * 2 1 3 
 * 3 1 2 
 * 1 3 2 
 * 2 3 1
 */

import java.util.*;

public class PermutationsII {

	private int[] getUpdatedNums(int[] nums, int i) {
		int[] arr = new int[nums.length - 1];
		for (int j = 0; j < i; j++) {
			arr[j] = nums[j];
		}
		for (int j = i+1; j < nums.length; j++) {
			arr[j-1] = nums[j];
		}
		return arr;
	}

    private void calcPermute(Set<List<Integer>> result, List<Integer> list, int[] nums) {
        if (nums.length == 0) {
            result.add(list);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
            calcPermute(result, new ArrayList<Integer>(list), getUpdatedNums(nums, i));
            list.remove(list.size()-1);
        }

        return;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<List<Integer>>();
        calcPermute(resultSet, new ArrayList<Integer>(), nums);
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (List<Integer> list : resultSet) {
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new PermutationsII().permuteUnique(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

