/**
 * https://leetcode.com/problems/permutation-sequence/description/
 *
 * Output:
 * ------
 * 213
 * 2314
 * 123
 */

import java.util.Arrays;

public class PermutationSequence {
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        
        while(k > 1){
            nextPermutation(nums);
            k--;
        }

        StringBuilder result = new StringBuilder(nums.length);

        for (int num : nums) {
            result.append(num);
        }

        return result.toString();
    }

    private int getNextHigherNumber(int number, int[] count) {
        for (int value = number + 1; value < count.length; value++) {
            if (count[value] > 0) {
                return value;
            }
        }

        return -1;
    }

    private void nextPermutation(int[] nums) {
        int[] count = new int[nums.length + 1];
        int pivot = nums.length - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }

        if (-1 == pivot) {
            return;
        }

        for (int i = pivot + 1; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int oldPivot = nums[pivot];
        int nextHigher = getNextHigherNumber(oldPivot, count);
        nums[pivot] = nextHigher;
        count[nextHigher]--;
        count[oldPivot]++;
        int index = pivot + 1;

        for (int value = 1; value <= nums.length; value++) {
            while (count[value] > 0) {
                nums[index++] = value;
                count[value]--;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PermutationSequence().getPermutation(3, 3));
        System.out.println(new PermutationSequence().getPermutation(4, 9));
        System.out.println(new PermutationSequence().getPermutation(3, 1));
    }
}

