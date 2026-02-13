/**
 * https://leetcode.com/problems/3sum-closest/?envType=problem-list-v2&envId=array
 * 
 *  Output:
 *  ------
 *  2
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ThreeSumClosest {

	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i+1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return sum;
                }
            }
        }

        return closestSum;
    }

	public static void main(String[] args) {
		int[] nums = {-1,2,1,-4};
		System.out.println(new ThreeSumClosest().threeSumClosest(nums, 1));
	}

}
