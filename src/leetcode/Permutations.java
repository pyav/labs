/**
 * https://leetcode.com/problems/permutations/
 *
 * Output:
 * ------
 * 1 2 3 
 * 1 3 2 
 * 2 1 3 
 * 2 3 1 
 * 3 1 2 
 * 3 2 1 
 */

import java.util.*;

public class Permutations {
    
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
	
	private List<List<Integer>> calcPermute(List<List<Integer>> result, List<Integer> list, int[] nums) {
		if (nums.length == 0) {
			result.add(list);
            return result;
		}
		
		for (int i = 0; i < nums.length; i++) {
			list.add(nums[i]);
			calcPermute(result, new ArrayList<Integer>(list), getUpdatedNums(nums, i));
            list.remove(list.size()-1);
		}
		
		return result;
	}
    
	public List<List<Integer>> permute(int[] nums) {
    	return calcPermute(new ArrayList<List<Integer>>(), new ArrayList<Integer>(), nums);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new Permutations().permute(nums);
        for (List<Integer> list : result) {
            for (Integer item : list) {
                System.out.printf("%d ", item);
            }
            System.out.println();
        }
    }

}

