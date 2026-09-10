/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
 *
 * Output:
 * ------
 * 1
 * 1
 * 0
 * 1
 * 1
 * 1
 * 1
 */

public class MinInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] < nums[end]) {
                end = mid;
            } else if (nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end--;
            }
        }

        return nums[start];
    }

    public static void main(String[] args) {
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{1,3,5}));
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{1}));
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{2,2,2,0,1}));
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{3,3,1,3}));
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{1,2,3}));
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{1,1,3,3,3,4,4,4,5,5}));
        System.out.println(new MinInRotatedSortedArrayII().findMin(new int[]{3,5,1}));
    }
}

