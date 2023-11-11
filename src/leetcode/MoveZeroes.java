/**
 * https://leetcode.com/problems/move-zeroes/
 *
 * Output:
 * ------
 * 1
 * 3
 * 12
 * 0
 * 0
 * 0
 */

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int posToUpdate = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[posToUpdate] = nums[i];
                posToUpdate++;
            }
        }
        for (int i = posToUpdate; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        new MoveZeroes().moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::println);
        int[] nums2 = {0};
        new MoveZeroes().moveZeroes(nums2);
        Arrays.stream(nums2).forEach(System.out::println);
    }
}

