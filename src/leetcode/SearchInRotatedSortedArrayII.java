/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * Output:
 * ------
 * true
 * false
 * false
 * true
 * false
 * true
 */

public class SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;
            if (target == nums[mid]) {
                return true;
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
            } else if (nums[start] <= nums[mid]) {
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

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{4,5,6,7,0,1,2}, 0));
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{4,5,6,7,0,1,2}, 3));
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{1}, 0));
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{2,5,6,0,0,1,2}, 0));
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{2,5,6,0,0,1,2}, 3));
        System.out.println(new SearchInRotatedSortedArrayII().search(new int[]{1,0,1,1,1}, 0));
    }
}

