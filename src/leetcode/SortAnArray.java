/**
 * https://leetcode.com/problems/sort-an-array/
 *
 * Output:
 * ------
 * 1 2 3 5 
 * 0 0 1 1 2 5 
 */

package leetcode;

import java.util.PriorityQueue;

public class SortAnArray {

    public int[] sortArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int n = nums.length;
        for (int i =0 ;i < n; i++) {
            pq.add(nums[i]);
        }
        int[] result = new int[n];
        for (int i =0 ;i < n; i++) {
            result[i] = pq.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,1};
        int[] result = new SortAnArray().sortArray(nums);
        for (int i = 0; i < result.length; i++) {
            System.out.printf("%d ", result[i]);
        }
        System.out.println();
        int[] nums2 = {5,1,1,2,0,0};
        int[] result2 = new SortAnArray().sortArray(nums2);
        for (int i = 0; i < result2.length; i++) {
            System.out.printf("%d ", result2[i]);
        }
        System.out.println();
    }

}

