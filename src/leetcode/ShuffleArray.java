/**
 * https://leetcode.com/problems/shuffle-the-array/
 * 
 * Output:
 * ------
 * 1
 * 4
 * 2
 * 3
 * 3
 * 2
 * 4
 * 1
 * 
 */

package leetcode;


class Solution {
    public int[] shuffle(int[] nums, int n) {
        
    	int nums2[] = new int[n*2];
    	int i, j;
    	
    	for (i = 0, j = 0; i < n*2-1 && j < n; i+=2, j+=1) {
    		nums2[i] = nums[j];
    		nums2[i+1] = nums[j+n];
    	}
    	
    	return nums2;
    }
}

public class ShuffleArray {

	public static void main(String[] args) {

		int nums[] = {1,2,3,4,4,3,2,1};
		Solution solution = new Solution();
		int nums2[] = solution.shuffle(nums, nums.length/2);
		for (int i = 0; i < nums.length; i++) {
			System.out.println(nums2[i]);
		}
	}

}
