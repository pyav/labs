/**
 * https://leetcode.com/problems/search-insert-position/
 *
 * Output:
 * ------
 * 2
 * 1
 * 4
 * 1
 * 0
 */

public class SearchInsertPosition {

    private int calcPosition(int[] nums, int target, int start, int end) {
        if (target > nums[end]) {
            return end+1;
        } else if (target < nums[start]) {
            return start;
        }

        int mid = start + (end - start)/2;

        while (start <= end) {
            mid = start + (end - start)/2;
            if (target == nums[mid]) {
                break;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
                mid = mid +1;
            }
        }

        return mid;
    }

    public int searchInsert(int[] nums, int target) {
        return calcPosition(nums, target, 0, nums.length-1);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        System.out.println(new SearchInsertPosition().searchInsert(nums, 5));
        System.out.println(new SearchInsertPosition().searchInsert(nums, 2));
        System.out.println(new SearchInsertPosition().searchInsert(nums, 7));
        int[] nums2 = {1,3};
        System.out.println(new SearchInsertPosition().searchInsert(nums2, 2));
        int[] nums3 = {1,3};
        System.out.println(new SearchInsertPosition().searchInsert(nums3, 1));
    }

}

