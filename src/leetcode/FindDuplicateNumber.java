/**
 * https://leetcode.com/problems/find-the-duplicate-number/description/
 *
 * Output:
 * ------
 * 2
 * 3
 * 2
 */

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        boolean[] present = new boolean[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (present[nums[i]]) {
                result = nums[i];
                break;
            }
            present[nums[i]] = true;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new FindDuplicateNumber().findDuplicate(nums));
        int[] nums2 = {3,1,3,4,2};
        System.out.println(new FindDuplicateNumber().findDuplicate(nums2));
        int[] nums3 = {2,2,2,2};
        System.out.println(new FindDuplicateNumber().findDuplicate(nums3));
    }

}

