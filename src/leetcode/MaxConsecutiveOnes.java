/**
 * https://leetcode.com/problems/max-consecutive-ones/description/
 *
 * Output:
 * ------
 * 3
 * 2
 */

public class  MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;
        if (nums[0] == 1) {
            count++;
            max = count;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 1) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
        int[] nums2 = {1,0,1,1,0,1};
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums2));
    }

}

