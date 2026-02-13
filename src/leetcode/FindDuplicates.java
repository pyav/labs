/**
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 * 
 * Output:
 * ------
 * 2 3 
 * 1 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class FindDuplicates {
	
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
        	if (nums[Math.abs(nums[i])-1] < 0) {
        		result.add(Math.abs(nums[i]));
        		continue;
        	}
        	nums[Math.abs(nums[i])-1] = -1 * nums[Math.abs(nums[i])-1];
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = new FindDuplicates().findDuplicates(nums);
		result.stream().forEach(i -> System.out.printf("%d ", i));
		System.out.println();
		int[] nums2 = {1,1,2};
		List<Integer> result2 = new FindDuplicates().findDuplicates(nums2);
		result2.stream().forEach(i -> System.out.printf("%d ", i));
		System.out.println();
		int[] nums3 = {1};
		List<Integer> result3 = new FindDuplicates().findDuplicates(nums3);
		result3.stream().forEach(i -> System.out.printf("%d ", i));
		System.out.println();
	}

}
