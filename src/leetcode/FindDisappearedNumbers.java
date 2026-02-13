/**
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
 * 
 *  Output:
 *  ------
 *  5 6
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindDisappearedNumbers {

	public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
        	set.add(nums[i]);
        }
        for (int i = 1; i <= nums.length; i++) {
        	if (!set.contains(i)) {
        		result.add(i);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		List<Integer> result = new FindDisappearedNumbers().findDisappearedNumbers(nums);
		result.stream().forEach(i -> System.out.printf("%d ", i));
		System.out.println();
	}

}
