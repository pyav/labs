/**
 * Link: https://leetcode.com/problems/two-sum/
 * 
 * Output:
 * ------
 * 0 1
 */

package leetcode;

public class TwoSum{
    public int[] twoSum(int[] nums, int target) {
        int[] indexes = new int[2];
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (target == nums[i]+nums[j]) {
                    indexes[0]=i;
                    indexes[1]=j;
                    found=true;
                    break;
                }
            }
            if (found)
                break;
        }
        return indexes;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int[] result = new TwoSum().twoSum(nums, 6);
        System.out.printf("%d %d", result[0], result[1]);
    }
}
