import java.util.Arrays;

/**
 * https://leetcode.com/problems/first-missing-positive/
 * 
 *  Output:
 *  ------
 *  3
 *  2
 *  1
 *  3
 */

public class FirstMissingPositive {

	public int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		int result = 1;
		int i = 0;
		for (; i < nums.length; i++) {
			if (nums[i] == result) {
				break;
			}
		}
		if (i == nums.length) return result;
		int j = i+1;
		
		for (; j < nums.length; j++) {
			if (nums[j] == nums[j-1]) continue;
			if (nums[j] != result+1) {
				result += 1;
				break;
			} else {
				result += 1;
			}
		}
		if (j == nums.length) {
			return result+1;
		}
		return result;
    }

	public static void main(String[] args) {
		int[] nums = {1,2,0};
		System.out.println(new FirstMissingPositive().firstMissingPositive(nums));
		int[] nums2 = {3,4,-1,1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(nums2));
		int[] nums3 = {7,8,9,11,12};
		System.out.println(new FirstMissingPositive().firstMissingPositive(nums3));
		int[] nums4 = {0,2,2,1,1};
		System.out.println(new FirstMissingPositive().firstMissingPositive(nums4));
	}

}
