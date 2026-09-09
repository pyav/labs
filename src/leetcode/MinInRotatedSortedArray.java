/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
 *
 * Output:
 * ------
 * 0
 * 1
 * 1
 * 11 
 */

public class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] > nums[end]) {
                start = mid+1;
            } else {
                end = mid;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(new MinInRotatedSortedArray().findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(new MinInRotatedSortedArray().findMin(new int[]{1}));
        System.out.println(new MinInRotatedSortedArray().findMin(new int[]{3,4,5,1,2}));
        System.out.println(new MinInRotatedSortedArray().findMin(new int[]{11,13,15,17}));
    }
}

