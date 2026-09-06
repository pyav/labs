/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Output:
 * ------
 * 4
 * -1
 * -1
 */

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(new SearchInRotatedSortedArray().search(new int[]{1}, 0));
    }
}

