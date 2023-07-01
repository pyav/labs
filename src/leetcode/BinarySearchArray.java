/**
 * https://leetcode.com/problems/binary-search/description/
 *
 * Output:
 * ------
 * 4
 * -1
 * 1
 * -1
 * -1
 * 0
 */

public class BinarySearchArray {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        System.out.println(new BinarySearchArray().search(nums, 9));
        int[] nums2 = {-1,0,3,5,9,12};
        System.out.println(new BinarySearchArray().search(nums2, 2));
        int[] nums3 = {-1,0,3,4,5,9,12};
        System.out.println(new BinarySearchArray().search(nums3, 0));
        int[] nums4 = {-1};
        System.out.println(new BinarySearchArray().search(nums4, 0));
        int[] nums5 = {-1,1};
        System.out.println(new BinarySearchArray().search(nums5, 0));
        int[] nums6 = {0};
        System.out.println(new BinarySearchArray().search(nums6, 0));
    }

}

