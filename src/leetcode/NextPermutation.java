/**
 * https://leetcode.com/problems/next-permutation/
 *
 * Output:
 * ------
 * 0 0 1 1 1 
 */

import java.util.Arrays;

public class NextPermutation {
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    private int getNextHigherNumber(int number, int[] count) {
        for (int value = number + 1; value < count.length; value++) {
            if (count[value] > 0) {
                return value;
            }
        }

        return -1;
    }

    public void nextPermutation(int[] nums) {
        int[] count = new int[101];
        int pivot = nums.length - 2;

        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            count[nums[pivot + 1]]++;
            pivot--;
        }

        if (pivot < 0) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        count[nums[pivot + 1]]++;
        count[nums[pivot]]++;
        int nextHigher = getNextHigherNumber(nums[pivot], count);
        nums[pivot] = nextHigher;
        count[nextHigher]--;
        int index = pivot + 1;

        for (int value = 0; value <= 100; value++) {
            while (count[value] > 0) {
                nums[index++] = value;
                count[value]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0};
        new NextPermutation().nextPermutation(nums);
        Arrays.stream(nums).forEach(x -> System.out.printf("%d ", x));
    }
}

