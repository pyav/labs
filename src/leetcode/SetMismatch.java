/**
 * https://leetcode.com/problems/set-mismatch/description/
 *
 * Output:
 * ------
 * 2, 3
 * 1, 2
 * 2, 1
 * 2, 1
 * 2, 1
 */

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;

            if (nums[idx] > 0) {
                nums[idx] *= -1;
            } else {
                result[0] = Math.abs(nums[i]);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result[1] = i+1;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,4};
        int[] result = new SetMismatch().findErrorNums(nums);
        System.out.printf("%d, %d\n", result[0], result[1]);

        int[] nums2 = {1,1};
        int[] result2 = new SetMismatch().findErrorNums(nums2);
        System.out.printf("%d, %d\n", result2[0], result2[1]);

        int[] nums3 = {2,2};
        int[] result3 = new SetMismatch().findErrorNums(nums3);
        System.out.printf("%d, %d\n", result3[0], result3[1]);

        int[] nums4 = {2,2,3};
        int[] result4 = new SetMismatch().findErrorNums(nums4);
        System.out.printf("%d, %d\n", result4[0], result4[1]);

        int[] nums5 = {3,2,2};
        int[] result5 = new SetMismatch().findErrorNums(nums5);
        System.out.printf("%d, %d\n", result5[0], result5[1]);
    }
}
